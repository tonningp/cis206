class Dog extends Animal {
    private String breed; 
    Dog(String name, String breed, String color, String size) {
        super(name,color,size); // Call the constructor of the superclass (Animal)
        this.breed = breed;
        System.out.println("Dog created");      //
    }

    @Override
    void eat() {
        System.out.println("The dog named " + getName() + " eats dog food.");
    }

    @Override
    void feed() {
        super.feed(); // Call the feed method of the superclass (Animal)
        System.out.println("This dog named " + getName() + " is being fed with dog food.");
    }

    void bark() {
        System.out.println("The dog barks.");
    }

    @Override
    public String toString() {
        return "Dog:{name='" + getName() + "', breed='" + breed + "'," +
                "color='" + getColor() + "', size='" + getSize() + "'}";

    }
}

