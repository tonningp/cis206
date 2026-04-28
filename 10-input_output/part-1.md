## Part 1: Console I/O, Formatting, and String Streams

Key idea: Java programs communicate through streams. Input streams bring data into the program; output streams send data out.

Core points:

`System.out` is the standard output stream.
`System.in` is the standard input stream.
`Scanner` wraps `System.in` and makes input easier to parse.
Formatted output allows controlled display of numbers, alignment, and text.

Example: basic input and output

```java
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
```

Important distinction:

```java
next()      // reads one token
nextLine()  // reads the whole line
nextInt()   // reads an integer
nextDouble()// reads a decimal number
```

Common bug:

```java
int age = input.nextInt();
String name = input.nextLine(); // reads leftover newline
```

Corrected version:

```java
int age = input.nextInt();
input.nextLine(); // consume leftover newline
String name = input.nextLine();
```

Formatted output:

```java
public class OutputFormatting {
    public static void main(String[] args) {
        String item = "Notebook";
        int quantity = 3;
        double price = 4.567;

        System.out.printf("%-12s %5s %10s%n", "Item", "Qty", "Price");
        System.out.printf("%-12s %5d %10.2f%n", item, quantity, price);
    }
}
```

Teaching emphasis:

`printf` is useful when output must be readable, aligned, or rounded.
`%.2f` means show two digits after the decimal point.
`%-12s` means left-align a string in a 12-character field.

String parsing example:

```java
import java.util.Scanner;

public class StringParsing {
    public static void main(String[] args) {
        String record = "Alice 92 87 95";
        Scanner lineScanner = new Scanner(record);

        String name = lineScanner.next();
        int exam1 = lineScanner.nextInt();
        int exam2 = lineScanner.nextInt();
        int exam3 = lineScanner.nextInt();

        double average = (exam1 + exam2 + exam3) / 3.0;

        System.out.printf("%s average: %.1f%n", name, average);
    }
}
```

Main point: a `Scanner` can read from the keyboard, but it can also parse a `String`.

---

