package figures;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        x=p.x;
        y=p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point p){
        return Math.sqrt(Math.pow(p.x-x,2)+Math.pow(p.y-y,2));
    }

    @Override
    public String toString() {
        return ("(" + x + ";" + y + ")");
    }
}
