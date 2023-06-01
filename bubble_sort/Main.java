import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    void bubbleSort(Integer[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
        .flatMap(i -> IntStream.range(1, n - i))
        .forEach(j -> {
            if (arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                }
         });
    }
    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static void main(String [] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
        numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);

    }
}