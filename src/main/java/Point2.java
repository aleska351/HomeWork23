public class Point2 {
    private final Object lock = new Object();
    private int x;
    private int y;

    public void move(int dx, int dy) {
        synchronized (lock) {
            x += dx;
            y += dy;
        }
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
