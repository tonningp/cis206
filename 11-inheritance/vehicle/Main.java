class Vehicle {
    void move() {
        System.out.println("Vehicle is moving.");
    }
}

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("Car is driving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();  // upcasting
        v.move();               // calls Car's version at runtime
    }
}
