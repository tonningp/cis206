class Bird extends Animal {
    private String species; 
    Bird(String name, String species, String color, String size) {
        super(name,color,size); // Call the constructor of the superclass (Animal)
        this.species = species;
        System.out.println("Bird created");      //
    }

    void chirp() {
        System.out.println("The bird chirps.");
    }

    @Override
    void feed() {
        super.feed(); // Call the feed method of the superclass (Animal)
        System.out.println("This bird named " + getName() + " is being fed with seeds.");
    }

    @Override
    public String toString() {
        return "Bird:{name='" + getName() + "', species='" + species + "', color='" + getColor() + "', size='" + getSize() + "'}";
    }
}
