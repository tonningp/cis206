## Part 1: Console I/O, Formatting, and String Streams

Key idea: Java programs communicate through streams. Input streams bring data into the program; output streams send data out.

Core talking points:

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

## Part 2: File Input and File Output

Key idea: files are also streams. Instead of reading from the keyboard or writing to the screen, the program reads from or writes to a file.

File input example:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputExample {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("students.txt");
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        fileScanner.close();
    }
}
```

Example `students.txt`:

```text
Alice 92
Bob 85
Carlos 78
```

Parsing file data:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeFileReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("students.txt"));

        while (fileScanner.hasNext()) {
            String name = fileScanner.next();
            int score = fileScanner.nextInt();

            System.out.printf("%-10s %3d%n", name, score);
        }

        fileScanner.close();
    }
}
```

File output example:

```java
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutputExample {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("report.txt");

        output.println("Student Report");
        output.println("--------------");
        output.printf("%-10s %3d%n", "Alice", 92);
        output.printf("%-10s %3d%n", "Bob", 85);

        output.close();
    }
}
```

Critical teaching point: file output must be closed.
If `close()` is omitted, some data may not be written.

Practical combined example:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeReport {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("students.txt"));
        PrintWriter outputFile = new PrintWriter("grade_report.txt");

        outputFile.printf("%-10s %10s%n", "Name", "Score");
        outputFile.println("----------------------");

        while (inputFile.hasNext()) {
            String name = inputFile.next();
            int score = inputFile.nextInt();

            outputFile.printf("%-10s %10d%n", name, score);
        }

        inputFile.close();
        outputFile.close();
    }
}
```

Suggested lecture framing:

Part 1 focuses on streams as interaction: keyboard input, screen output, formatting, and parsing strings.

Part 2 extends the same concept to persistence: reading data from files, processing it, and writing results to new files. The logical pattern is:

```text
input → process → output
```

That pattern is the central model students should retain.
