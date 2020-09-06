package figures;

public class Square extends Figure{

    private Point a,b,c,d;

    public Square(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getSquare() {
        return a.distanceTo(b)*a.distanceTo(b);
    }

    @Override
    public double getPerimeter() {
        return 4*a.distanceTo(b);
    }
}
