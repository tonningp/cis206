abstract class Animal {
    private String name;
    private String color;
    private String size;
   
    Animal(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    abstract void eat();

    void feed() {
        System.out.println("This animal named " + this.name + " is being fed.");
        System.out.println("Instructions:");
        System.out.println("1. Open the animal's enclosure carefully.");
        System.out.println("2. Provide fresh water daily.");
        System.out.println("3. Offer a balanced diet suitable for the animal's species.");
        System.out.println("4. Ensure the food is clean and free from contaminants.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Animal:{name='" + name + "', color='" + color + "', size='" + size + "'}";
    }


}
