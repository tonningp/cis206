public class Lizard extends Animal {
    private String species;
    private boolean isVenomous;

    Lizard(String name, String species,String color, String size, boolean isVenomous) {
        super(name, color, size);
        this.species = species;
        this.isVenomous = isVenomous;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    void feed() {
        super.feed(); // Call the feed method of the superclass (Animal)
        System.out.println("This lizard named " + getName() + " is being fed with insects.");
    }

    @Override
    public String toString() {
        return "Lizard{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", size='" + getSize() + '\'' +
                ", isVenomous=" + isVenomous +
                '}';
    }

}
