import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        korobka box = new korobka(300);
        Cylinder cyl = new Cylinder(4, 2);
        Sarik ball = new Sarik(3);
        Pyramida pyr = new Pyramida(10, 15);
        System.out.println("Цилиндр: " + box.add(cyl));
        System.out.println("Шар: " + box.add(ball));
        System.out.println("Пирамида: " + box.add(pyr));
    }
}


abstract class Shape {
    public abstract double Objom();
}

class korobka extends Shape {
    ArrayList<Shape> shapes = new ArrayList<>();
    double volume;
    double free;
    public korobka(double free) {
        this.volume = free;
        this.free = free;
    }

    public boolean add(Shape shape) {
        if (free >= shape.Objom()) {
            shapes.add(shape);
            free -= shape.Objom();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double Objom() {
        return volume;
    }
}
class Pyramida extends Shape{
    double h;
    double s;
    public Pyramida(double h, double s) {
        this.h = h;
        this.s = s;
    }
    @Override
    public double Objom() {
        return h*s*4/3;
    }
}
abstract class SolidOfRevolution extends Shape {
    double radius;
    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
class Cylinder extends SolidOfRevolution{
    double height;
    
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }
    @Override
    public double Objom() {
        return Math.PI*radius*radius*height;
    }
}
class Sarik extends SolidOfRevolution {
    public Sarik(double radius) {
        super(radius);
    }
    @Override
    public double Objom() {
        return Math.PI*Math.pow(radius, 3)*4/3;
    }
}