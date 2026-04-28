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

## Remember: input and output are two sides of the same coin. A program that processes data typically follows this pattern:
```text
input → process → output
```
