public class Point4 {
    private int x;
    private int y;

    public static synchronized void move(Point4 point, int dx, int dy) {
        point.x += dx;
        point.y += dy;
    }


    @Override
    public String toString() {
        return "Point4{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
