import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PointDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);
        Point1 point1 = new Point1();
        Point2 point2 = new Point2();
        Point3 point3 = new Point3();
        Point4 point4 = new Point4();
 /*
 Метод synchronized
  */
        for (int i = 0; i < 2_000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    point1.move(1,1);
                }
            });
        }

        /*
        Блок synchronized. Монитор lock в нестатическом методе
         */
        for (int i = 0; i < 2_000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                   point2.move(1,1);
                }
            });
        }

        /*
        Блок synchronized. Монитор lock в статическом методе
         */
        for (int i = 0; i < 2_000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Point3.move(point3, 1, 1);
                }
            });
        }

        /*
        Метод synchronized. Монитор X.class
         */
        for (int i = 0; i < 2_000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Point4.move(point4, 1, 1);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.MINUTES);
        } catch (InterruptedException ignored) {
        }

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);
    }
}
