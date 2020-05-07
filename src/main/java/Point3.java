class Point3 {
    private static final Object lock = new Object();
    private int x;
    private int y;

    public static void move(Point3 point3, int dx, int dy) {
        synchronized (lock) {
            point3.x += dx;
            point3.y += dy;
        }
    }


    @Override
    public String toString() {
        return "Point3{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
