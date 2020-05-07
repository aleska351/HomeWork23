import java.math.BigInteger;
import java.util.concurrent.*;

public class FibonacciRunnableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<?> future = executor.submit(new Runnable() {
            BigInteger n;
            BigInteger current = BigInteger.valueOf(1);
            BigInteger previous = BigInteger.valueOf(1);

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    fibonacciNumber();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        System.out.println("Sleep was interrupted");
                        System.out.println("Previous number Fibonacci " + previous);
                        System.out.println("Next number Fibonacci " + current);
                        return;
                    }
                }
            }

            private void fibonacciNumber() {
                n = previous.add(current);
                System.out.print(n + " ");
                previous = current;
                current = n;
            }
        });
        try {
            // прерываем через 3 секунды (при увеличении времени и кол-ва потоков, числа отличаются в Thread  и Runnable
            future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Task has timed out");
            future.cancel(true);
        }
        executor.shutdown();
    }
}
