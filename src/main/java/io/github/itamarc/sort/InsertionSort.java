package io.github.itamarc.sort;

public class InsertionSort extends SortAlgorithm {
    /**
     * INSERTION SORT
     * 
     * The most common variant of insertion sort, which operates on arrays, can be described as follows:
     * - Suppose there exists a function called Insert designed to insert a value into a sorted sequence
     *   at the beginning of an array. It operates by beginning at the end of the sequence and shifting
     *   each element one place to the right until a suitable position is found for the new element.
     *   The function has the side effect of overwriting the value stored immediately after the sorted
     *   sequence in the array.
     * - To perform an insertion sort, begin at the left-most element of the array and invoke Insert to
     *   insert each element encountered into its correct position. The ordered sequence into which the
     *   element is inserted is stored at the beginning of the array in the set of indices already examined.
     *   Each insertion overwrites a single value: the value being inserted.
     * 
     * Ref: https://en.wikipedia.org/wiki/Insertion_sort
     * 
     * @param array
     */
    public static void sort(int[] array) {
        int ind = 1;
        // for each element in the array
        while (ind < array.length) {
            int curr = ind; // loook at the values of the array previous to the current one
            // if the previous elem is bigger than the current one, swap them and start again from there
            while (curr > 0 && array[curr-1] > array[curr]) {
                swap(array, curr, curr-1);
                curr--;
            }
            ind++;
        }
    }

    /**
     * Recursive version of insertion sort.
     * 
     * @param array The array to be sorted
     * @param rightIndex Initially the index of the last element of the array (inArr.length-1)
     */
    public static void sortRecursive(int[] array, int rightIndex) {
        if (rightIndex > 0) {
            sortRecursive(array, rightIndex-1);
            int x = array[rightIndex];
            int j = rightIndex-1;
            while (j >= 0 && array[j] > x) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
        }
    }
}
