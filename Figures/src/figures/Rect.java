package figures;

public class Rect extends Figure {

    private Point a,b,c,d;

    public Rect(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getSquare() {
        return a.distanceTo(b)*b.distanceTo(c);
    }

    @Override
    public double getPerimeter() {
        return 2*(a.distanceTo(b)+b.distanceTo(c));
    }
}
