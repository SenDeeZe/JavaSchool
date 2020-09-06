package figures;

public class Triangle extends Figure {

    private Point a,b,c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSquare() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-a.distanceTo(b))*(p-a.distanceTo(c))*(p-b.distanceTo(c)));
    }

    @Override
    public double getPerimeter() {
        return a.distanceTo(b)+a.distanceTo(c)+b.distanceTo(c);
    }
}
