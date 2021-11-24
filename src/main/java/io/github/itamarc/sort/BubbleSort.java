package io.github.itamarc.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by
 * repeatedly swapping the adjacent elements if they are in wrong order,
 * in consecutive passes until a whole pass is made without any swap.
 */
public class BubbleSort extends SortAlgorithm {
    public static void sort(int[] array) {
        boolean unsorted = true;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    unsorted = true;
                }
            }
        }
    }
}
