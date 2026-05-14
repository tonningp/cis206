# Lecture: Recursion in Java

## Key Idea

Recursion occurs when a method solves a problem by calling itself on a smaller version of the same problem.

A recursive method must have two parts:

1. A base case: the condition that stops the recursion.
2. A recursive case: the part where the method calls itself with a smaller or simpler input.

Without a base case, recursion continues until the program crashes with a `StackOverflowError`.

---

# 1. Countdown Example

## Pseudocode

```text
method countdown(n)
    if n is 0
        print "Done"
        stop

    print n
    countdown(n - 1)
```

## Java Implementation

```java
public class CountdownExample {

    public static void countdown(int n) {
        if (n == 0) {
            System.out.println("Done");
            return;
        }

        System.out.println(n);
        countdown(n - 1);
    }

    public static void main(String[] args) {
        countdown(5);
    }
}
```

## Output

```text
5
4
3
2
1
Done
```

The problem becomes smaller each time because `n` decreases by 1.

---

# 2. Factorial Example

Factorial means:

```text
5! = 5 * 4 * 3 * 2 * 1
```

## Pseudocode

```text
method factorial(n)
    if n is 0
        return 1

    return n * factorial(n - 1)
```

## Java Implementation

```java
public class FactorialExample {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
}
```

## Output

```text
120
```

## Call Expansion

```text
factorial(5)
5 * factorial(4)
5 * 4 * factorial(3)
5 * 4 * 3 * factorial(2)
5 * 4 * 3 * 2 * factorial(1)
5 * 4 * 3 * 2 * 1 * factorial(0)
5 * 4 * 3 * 2 * 1 * 1
120
```

---

# 3. Sum of Numbers Example

This computes:

```text
sum(5) = 5 + 4 + 3 + 2 + 1
```

## Pseudocode

```text
method sum(n)
    if n is 0
        return 0

    return n + sum(n - 1)
```

## Java Implementation

```java
public class SumExample {

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int result = sum(5);
        System.out.println(result);
    }
}
```

## Output

```text
15
```

This example is structurally similar to factorial, but it adds instead of multiplies.

---

# 4. Fibonacci Example

The Fibonacci sequence begins:

```text
0, 1, 1, 2, 3, 5, 8, 13
```

Each number is the sum of the two previous numbers.

## Pseudocode

```text
method fibonacci(n)
    if n is 0
        return 0

    if n is 1
        return 1

    return fibonacci(n - 1) + fibonacci(n - 2)
```

## Java Implementation

```java
public class FibonacciExample {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int result = fibonacci(6);
        System.out.println(result);
    }
}
```

## Output

```text
8
```

This example has two recursive calls. It is useful for learning recursion, but inefficient for large values because it repeats work.

---

# 5. Recursive Array Search

This checks whether a target value exists in an array.

## Pseudocode

```text
method contains(array, index, target)
    if index reaches end of array
        return false

    if array[index] equals target
        return true

    return contains(array, index + 1, target)
```

## Java Implementation

```java
public class RecursiveSearchExample {

    public static boolean contains(int[] numbers, int index, int target) {
        if (index >= numbers.length) {
            return false;
        }

        if (numbers[index] == target) {
            return true;
        }

        return contains(numbers, index + 1, target);
    }

    public static void main(String[] args) {
        int[] values = {4, 8, 15, 16, 23, 42};

        boolean found = contains(values, 0, 23);

        System.out.println(found);
    }
}
```

## Output

```text
true
```

This example shows that recursion does not always move toward zero. Sometimes it moves through a data structure.

---

# 6. Recursive String Reversal

## Pseudocode

```text
method reverse(text)
    if text length is 0 or 1
        return text

    return reverse(text without first character) + first character
```

## Java Implementation

```java
public class ReverseStringExample {

    public static String reverse(String text) {
        if (text.length() <= 1) {
            return text;
        }

        return reverse(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        String result = reverse("Java");
        System.out.println(result);
    }
}
```

## Output

```text
avaJ
```

The string becomes smaller each time because the first character is removed before the recursive call.

---

# How Java Implements Recursion

When a method is called, Java creates a new stack frame.

Each stack frame stores:

```text
method arguments
local variables
return address
temporary calculations
```

For example:

```java
factorial(3)
```

Creates a call stack like this:

```text
factorial(0)
factorial(1)
factorial(2)
factorial(3)
main()
```

When the base case is reached, the calls return in reverse order:

```text
factorial(0) returns 1
factorial(1) returns 1 * 1
factorial(2) returns 2 * 1
factorial(3) returns 3 * 2
```

This process is called stack unwinding.

---

# Common Recursion Pattern

```java
public static returnType methodName(parameters) {
    if (baseCaseCondition) {
        return baseCaseValue;
    }

    return methodName(smallerProblem);
}
```

For `void` methods:

```java
public static void methodName(parameters) {
    if (baseCaseCondition) {
        return;
    }

    // do something

    methodName(smallerProblem);
}
```

---

# Teaching Summary

Recursion is useful when a problem can naturally be divided into smaller versions of itself.

Good recursive algorithms have:

```text
a clear stopping point
a smaller recursive step
a return path
```

The essential question is:

```text
What is the smallest version of this problem that I already know how to solve?
```


# Real Use Cases for Recursion

Recursion is commonly used when data or processes are naturally hierarchical, nested, or self-similar.

---

# 1. File System Traversal

Operating systems organize files in nested directories.

A recursive algorithm can explore folders inside folders.

## Example

```text
Documents/
    School/
        Java/
    Photos/
        Vacation/
```

## Recursive Idea

```text
visit folder
    process files
    for each subfolder
        visit subfolder
```

## Real Applications

* File search utilities
* Backup software
* Antivirus scanners
* Disk usage analyzers

---

# 2. Parsing Mathematical Expressions

Compilers and interpreters use recursion to evaluate expressions.

## Example

```text
(4 + (2 * 3))
```

The expression contains smaller expressions inside itself.

## Real Applications

* Java compiler
* Calculators
* SQL parsers
* Programming language interpreters

---

# 3. Tree Data Structures

Trees are inherently recursive.

Each node may contain child nodes that are themselves trees.

## Example Structures

* Binary search trees
* AVL trees
* Red-black trees

## Real Applications

* Databases
* Search engines
* Compilers
* AI decision systems

---

# 4. Web Crawlers

A web crawler recursively follows hyperlinks.

## Recursive Logic

```text
visit webpage
for each link
    visit linked page
```

## Real Applications

* Search engines
* Site indexing
* SEO analysis tools
* Web archival systems

---

# 5. Recursive GUI Rendering

Graphical user interfaces often contain nested components.

## Example

```text
Window
    Panel
        Button
        TextBox
```

Each component may contain additional components.

## Real Applications

* Swing
* JavaFX
* Web browsers
* Game UI systems

---

# 6. Fractals and Computer Graphics

Fractals are self-similar shapes generated recursively.

## Examples

* Mandelbrot set
* Koch snowflake
* Recursive trees

## Real Applications

* Computer graphics
* Terrain generation
* Scientific visualization
* Procedural game worlds

---

# 7. Artificial Intelligence Game Trees

Games often use recursive search algorithms.

## Example

Chess engines evaluate future moves recursively.

```text
my move
    opponent move
        my move
            opponent move
```

## Real Applications

* Chess engines
* Checkers AI
* Strategy games
* Pathfinding systems

---

# 8. Sorting Algorithms

Some of the most important algorithms use recursion.

## Examples

* Merge sort
* Quick sort

## Recursive Structure

```text
divide problem
solve smaller pieces
combine results
```

## Real Applications

* Database engines
* Operating systems
* Search infrastructure
* Data analytics systems

---

# 9. JSON or XML Parsing

Nested data formats are recursive by nature.

## Example JSON

```json
{
  "user": {
    "address": {
      "city": "Los Angeles"
    }
  }
}
```

Objects contain objects.

## Real Applications

* REST APIs
* Web applications
* Configuration systems
* Data interchange

---

# 10. Backtracking Algorithms

Backtracking explores possibilities recursively.

## Examples

* Sudoku solvers
* Maze solving
* Password cracking
* Constraint satisfaction problems

## Recursive Idea

```text
try choice
if invalid
    undo choice
try another
```

## Real Applications

* Optimization software
* Scheduling systems
* Robotics
* Puzzle solvers

---

# Why Recursion Is Valuable

Recursion is most useful when:

```text
the problem contains smaller versions of itself
the structure is hierarchical
the depth is unknown beforehand
```

Common recursive domains include:

```text
trees
graphs
nested data
search spaces
mathematical definitions
```

---

# Important Tradeoff

Recursion improves clarity for many algorithms, but it has costs:

```text
more stack memory
additional method calls
possible stack overflow
```

In performance-critical systems, recursion is sometimes replaced with:

```text
loops
explicit stacks
iterative algorithms
```

However, many recursive solutions are substantially easier to reason about mathematically and structurally.
