package io.github.itamarc.sort;

import java.util.Arrays;

public class MergeSort extends SortAlgorithm {
    /**
     * MERGE SORT
     * 
     * https://en.wikipedia.org/wiki/Merge_sort
     * 
     * Conceptually, a merge sort works as follows:
     * - Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
     * - Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.
     * 
     * This implementation is a Top-Down Merge Sort.
     * 
     * @param inArr The float array to be sorted
     * @return A sorted float array
     */
    public static float[] sort(float[] inArr) {
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
}
