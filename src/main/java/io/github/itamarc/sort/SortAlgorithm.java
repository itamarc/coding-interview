package io.github.itamarc.sort;

public abstract class SortAlgorithm {
    /**
     * Swap two elements of an array.
     * 
     * @param array The array containing the elements
     * @param first First element index
     * @param second Second element index
     */
    protected static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
