import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        Dog d = new Dog("Buddy", "Golden Retriever", "Golden", "large");
        Cat c = new Cat("Whiskers", "Siamese", "Cream", "medium");
        Bird b = new Bird("Tweety", "Canary", "Yellow", "small");
        Lizard l = new Lizard("Lizzy", "Anole", "Green", "small", false);
        animals.add(d);
        animals.add(c);
        animals.add(b);
        animals.add(l);
        for (Animal a : animals) {
            System.out.println(a);
            a.feed();

        }
    }
}
