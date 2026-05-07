abstract class Shape {
    abstract double area();

    void describe() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle(3.0);
        s.describe();
        System.out.println("Area: " + s.area());
    }
}
