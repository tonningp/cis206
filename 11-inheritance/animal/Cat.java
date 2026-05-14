class Cat extends Animal {
    private String breed; 
    Cat(String name, String breed, String color, String size) {
        super(name,color,size); // Call the constructor of the superclass (Animal)
        this.breed = breed;
        System.out.println("Cat created");      //
    }

    void meow() {
        System.out.println("The cat meows.");
    }

    @Override
    void eat() {
        System.out.println("The cat named " + getName() + " is eating cat food .");
    }

    @Override
    void feed() {
        super.feed(); // Call the feed method of the superclass (Animal)
        System.out.println("This cat named " + getName() + " is being fed with cat food.");
    }

    @Override
    public String toString() {
        return "Cat:{name='" + getName() + "', breed='" + breed + "', color='" 
               + getColor() + "', size='" + getSize() + "'}";
    }

}
