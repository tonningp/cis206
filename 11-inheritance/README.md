The request can be interpreted as a need for concise, canonical demonstrations of inheritance using only the standard Java runtime (i.e., no external libraries). The following examples illustrate three distinct inheritance patterns: basic inheritance, method overriding (runtime polymorphism), and abstract class extension.

---

### Example 1: Basic Inheritance

A subclass acquires fields and methods from a superclass.

```java
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // inherited method
        d.bark();  // subclass method
    }
}
```

---

### Example 2: Method Overriding (Runtime Polymorphism)

A subclass provides a specific implementation of a superclass method.

```java
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
```

---

### Example 3: Abstract Class Inheritance

An abstract class defines a contract; subclasses must implement abstract methods.

```java
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
```

---

These examples are sufficient to demonstrate:

* structural inheritance (Example 1),
* behavioral specialization via overriding (Example 2),
* and abstraction with enforced implementation (Example 3).
