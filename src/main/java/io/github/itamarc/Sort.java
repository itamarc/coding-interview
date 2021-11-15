package io.github.itamarc;

import java.util.Arrays;

public class Sort {
    /**
     * MERGE SORT
     * 
     * https://en.wikipedia.org/wiki/Merge_sort
     * 
     * Conceptually, a merge sort works as follows:
     * - Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
     * - Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.
     * 
     * @param inArr The float array to be sorted
     * @return A sorted float array
     */
    public static float[] topDownMergeSort(float[] inArr) {
        float[] wkArr;
        wkArr = Arrays.copyOf(inArr, inArr.length);
        topDownSplitMerge(wkArr, 0, inArr.length, inArr);
        return inArr;
    }

    // Split inArr[] into 2 runs, sort both runs into wkArr[], merge both runs from wkArr[] to inArr[]
    // ini is inclusive; end is exclusive (inArr[end] is not in the set).
    private static void topDownSplitMerge(float[] wkArr, int ini, int end, float[] inArr) {
        if (end - ini <= 1) {
            return;
        }
        // split the run longer than 1 item into halves
        int mid = (end + ini) / 2;
        // recursively sort both runs from array A[] into B[]
        topDownSplitMerge(inArr, ini, mid, wkArr);  // sort the left  run
        topDownSplitMerge(inArr, mid, end, wkArr);  // sort the right run
        // merge the resulting runs from array B[] into A[]
        topDownMerge(wkArr, ini, mid, end, inArr);
    }

    // Left source half is  wkArr[ ini:mid-1 ].
    // Right source half is wkArr[ mid:end-1 ].
    // Result is            inArr[ ini:end-1 ].
    private static void topDownMerge(float[] wkArr, int ini, int mid, int end, float[] inArr) {
        int i = ini;
        int e = mid;
        // While there are elements in the left or right runs...
        for (int k = ini; k < end; k++) {
            // If left run head exists and is <= existing right run head.
            if (i < mid && (e >= end || wkArr[i] <= wkArr[e])) {
                inArr[k] = wkArr[i];
                i++;
            } else {
                inArr[k] = wkArr[e];
                e++;
            }
        }
    }

    /**
     * QUICK SORT
     * 
     * Quicksort is a type of divide and conquer algorithm for sorting an array, based on a
     * partitioning routine; the details of this partitioning can vary somewhat, so that 
     * quicksort is really a family of closely related algorithms.
     * 
     * The steps for in-place quicksort are:
     * - If the range has less than two elements, return immediately as there is nothing to do.
     *   Possibly for other very short lengths a special-purpose sorting method is applied and
     *   the remainder of these steps skipped.
     * - Otherwise pick a value, called a pivot, that occurs in the range (the precise manner of
     *   choosing depends on the partition routine, and can involve randomness).
     * - Partition the range: reorder its elements, while determining a point of division, so
     *   that all elements with values less than the pivot come before the division, while all
     *   elements with values greater than the pivot come after it; elements that are equal to
     *   the pivot can go either way. Since at least one instance of the pivot is present, most
     *   partition routines ensure that the value that ends up at the point of division is equal
     *   to the pivot, and is now in its final position (but termination of quicksort does not
     *   depend on this, as long as sub-ranges strictly smaller than the original are produced).
     * - Recursively apply the quicksort to the sub-range up to the point of division and to the
     *   sub-range after it, possibly excluding from both ranges the element equal to the pivot
     *   at the point of division. (If the partition produces a possibly larger sub-range near
     *   the boundary where all elements are known to be equal to the pivot, these can be excluded as well.)
     * 
     * This method implements the Hoare partition scheme.
     * Ref: https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme
     * 
     * @param inArr The array to be sorted.
     */
    public static void quickSort(int[] inArr) {
        quickSort(inArr, 0, inArr.length-1);
    }

    /**
     * The recursive implementation.
     * 
     * @param inArr The array to be sorted.
     * @param lo Lower index.
     * @param hi Higher index.
     */
    private static void quickSort(int[] inArr, int lo, int hi) {
        if (lo >= 0 && hi >=0 && lo < hi) {
            int pivot = qSPartition(inArr, lo, hi);
            quickSort(inArr, lo, pivot); // In this implementation, the pivot is included
            quickSort(inArr, pivot+1, hi);
        }
    }

    // In the partition is the main difference in Hoare implementation
    private static int qSPartition(int[] inArr, int lo, int hi) {
        // Value in the middle of the array
        int pivot = inArr[(lo + hi) / 2];

        // Left index
        int lIdx = lo - 1;
        // Right index
        int rIdx = hi + 1;

        while(true) {
            // Move the left index to the right at least once and while the element at 
            // the left index is less than the pivot 
            do {
                lIdx++; 
            } while (inArr[lIdx] < pivot); 
            
            // Move the right index to the left at least once and while the element at
            // the right index is greater than the pivot 
            do {
                rIdx--;
            } while (inArr[rIdx] > pivot);

            // If the indices crossed, return
            if (lIdx >= rIdx) {
                return rIdx;
            }

            // Swap the elements at the left and right indices
            swap(inArr, lIdx, rIdx);
        }
    }

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
     * @param inArr
     */
    public static void insertionSort(int[] inArr) {
        int i = 1;
        // for each element in the inArr
        while (i < inArr.length) {
            int j = i; // loook at the values of the array previous to the current one
            // if the previous elem is bigger than the current one, swap them and start again from there
            while (j > 0 && inArr[j-1] > inArr[j]) {
                swap(inArr, j, j-1);
                j--;
            }
            i++;
        }
    }

    /**
     * Swap two elements of an array.
     * 
     * @param array The array containing the elements
     * @param first First element index
     * @param second Second element index
     */
    public static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }

    /**
     * Recursive version of insertion sort.
     * 
     * @param inArr The array to be sorted
     * @param n Initially the index of the last element of the array (inArr.length-1)
     */
    public static void insertionSortRecursive(int[] inArr, int n) {
        if (n > 0) {
            insertionSortRecursive(inArr, n-1);
            int x = inArr[n];
            int j = n-1;
            while (j >= 0 && inArr[j] > x) {
                inArr[j+1] = inArr[j];
                j--;
            }
            inArr[j+1] = x;
        }
    }

    // public float[] someSortAlgorithm(float[] in) {
    //     float[] out = new float[in.length];
    //     // implement the sorting logic
    //     return out;
    // }
}
