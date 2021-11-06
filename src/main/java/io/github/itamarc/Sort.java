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
     * Ref: https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
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
            quickSort(inArr, lo, pivot);
            quickSort(inArr, pivot+1, hi);
        }
    }

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
            int tmp = inArr[lIdx];
            inArr[lIdx] = inArr[rIdx];
            inArr[rIdx] = tmp;
        }
    }

    // public float[] someSortAlgorithm(float[] in) {
    //     float[] out = new float[in.length];
    //     // implement the sorting logic
    //     return out;
    // }
}
