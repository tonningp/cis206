import java.util.Scanner;

public class ConsoleIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.println("Hello, " + name + ".");
        System.out.println("Next year you will be " + (age + 1) + ".");
    }
}
