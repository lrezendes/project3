package comp.comp152;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {
    public static void main(String[] args) {
        System.out.println("PROBLEM 1 (reverse 1k)\n----------------------");
        sortArray("src/1 - Reverse Order (1,000).txt", 1000);

        System.out.println("\nPROBLEM 2 (sorted 1k)\n---------------------");
        sortArray("src/2 - Already Sorted (1,000).txt", 1000);

        System.out.println("\nPROBLEM 3 (almost sorted 1k)\n----------------------------");
        sortArray("src/3 - Almost Sorted (1,000).txt", 1000);

        System.out.println("\nPROBLEM 4 (reverse 10k)\n-----------------------");
        sortArray("src/4 - Reverse Order 2 (10,000).txt", 10000);

        System.out.println("\nPROBLEM 5 (random 10k)\n----------------------");
        sortArray("src/5 - Random Numbers (10,000).txt", 10000);
    }

    public static void sortArray(String filename, int size) {
        int[] nums = readFile(filename, size);

        double bubbleTime = 0;
        for (int i = 0; i < 20; ++i) {
            int[] toSort = nums.clone();
            double bubbleStart = System.nanoTime();
            Sorts.bubbleSort(toSort);
            double bubbleEnd = System.nanoTime();
            bubbleTime += (bubbleEnd - bubbleStart);
        }
        bubbleTime = (bubbleTime / 10) / 1000000;

        double insertionTime = 0;
        for (int i = 0; i < 20; ++i) {
            int[] toSort = nums.clone();
            double insertionStart = System.nanoTime();
            Sorts.insertionSort(toSort);
            double insertionEnd = System.nanoTime();
            insertionTime += (insertionEnd - insertionStart);
        }
        insertionTime = (insertionTime / 10) / 1000000;

        double mergeTime = 0;
        for (int i = 0; i < 20; ++i) {
            int[] toSort = nums.clone();
            double mergeStart = System.nanoTime();
            Sorts.mergeSort(toSort, 0, toSort.length - 1);
            double mergeEnd = System.nanoTime();
            mergeTime += (mergeEnd - mergeStart);
        }
        mergeTime = (mergeTime / 10) / 1000000;

        System.out.printf("Bubble Sort took %fms on average to sort list of size %d.\n", bubbleTime, size);
        System.out.printf("Insertion Sort took %fms on average to sort list of size %d.\n", insertionTime, size);
        System.out.printf("Merge Sort took %fms on average to sort list of size %d.\n", mergeTime, size);
    }

    public static int[] readFile(String filename, int size) {
        int[] nums = new int[size];
        try {
            Scanner file = new Scanner(new File(filename));
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = Integer.parseInt(file.next());
            }
        } catch (FileNotFoundException ignored) {
            System.out.println(filename + " not found!");
        }
        return nums;
    }
}