import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileWriteSample {
  public static void main(String[] args) throws IOException {
     FileOutputStream fileStream = null;
     PrintWriter outFS = null;

     // Try to open file
     fileStream = new FileOutputStream("Main.java");
     outFS = new PrintWriter(fileStream);

     // Arriving here implies that the file can now be written
     // to, otherwise an exception would have been thrown.
     // write header command to file
     /*
    File: Main.java
    Description: this is the description for the project application.
    Author: Your Name
    Email: youremail@student.vvc.edu
    Course#: cis206
    Section#: your section number
    Date: the date you submitted this assignment
*/
     outFS.println("/*");
     outFS.println("File: Main.java");
     outFS.println("Description: this is the description for the project application.");
     outFS.println("Author: Your Name");
     outFS.println("Email: paul.tonning@student.vvc.edu");
     outFS.println("Course#: cis206");
     outFS.println("Section#: your section number");
     outFS.println("Date: the date you submitted this assignment");
     outFS.println("*/");
     outFS.println("import java.util.Scanner;");
     outFS.println("public class Main {");
     outFS.println("  public static void main(String[] args) {");
     outFS.println("    Scanner scnr = new Scanner(System.in);");
     outFS.println("    int userInt;");
     outFS.println("    userInt = scnr.nextInt();");
     outFS.println("    System.out.println(userInt);");
     outFS.println("  }");
     outFS.println("}");

     // Done with file, so try to close
     // Note that close() may throw an IOException on failure
     outFS.close();
  }
}
