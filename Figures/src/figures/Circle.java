package figures;

public class Circle extends Figure{

    private double r;
    private Point center;

    public Circle(Point center, double r){
        this.center = center;
        this.r = r;
    }

    @Override
    public double getSquare() {
        return Math.PI*r*r;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*r;
    }
}
