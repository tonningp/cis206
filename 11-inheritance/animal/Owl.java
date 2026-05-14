public class Owl extends Bird {
    private boolean canTurnHead360;

    Owl(String name, String species, String color, String size, boolean canTurnHead360) {
        super(name, species, color, size);
        this.canTurnHead360 = canTurnHead360;
        System.out.println("Owl created");
    }

    void hoot() {
        System.out.println("The owl hoots.");
    }

    @Override
    void eat() {
        System.out.println("The owl named " + getName() + " is eating mice.");
    }

    @Override
    void feed() {
        // super.feed(); // Call the feed method of the superclass (Bird)
        System.out.println("This owl named " + getName() + " is being fed with mice.");
    }

    @Override
    public String toString() {
        return "Owl:{name='" + getName() + "', species='" + getSpecies() + "', color='" + getColor() + "', size='" + getSize() + "', canTurnHead360=" + canTurnHead360 + "}";
    }
}
