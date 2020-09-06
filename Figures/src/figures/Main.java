package figures;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(0,0);
        Point b = new Point(0,1);
        Point c = new Point(1,1);
        Point d = new Point(1,0);
        Circle circ = new Circle(a,1);
        Triangle tri = new Triangle(a,b,c);
        Rect rec = new Rect(a,b,c,d);
        Square sq = new Square(a,b,c,d);
        System.out.println("Circle's perimeter = "+circ.getPerimeter());
        System.out.println("Circle's square = "+circ.getSquare());
        System.out.println("Triangle's perimeter = "+tri.getPerimeter());
        System.out.println("Triangle's square = "+tri.getSquare());
        System.out.println("Rectangle's perimeter = "+rec.getPerimeter());
        System.out.println("Rectangle's square = "+rec.getSquare());
        System.out.println("Square's perimeter = "+sq.getPerimeter());
        System.out.println("Square's square = "+sq.getSquare());
    }
}
