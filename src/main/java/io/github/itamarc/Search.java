package io.github.itamarc;

public class Search {
    /**
     * Search a sorted array by repeatedly dividing the search interval in half.
     * @param arr The sorted array to be searched.
     * @param n The number to be searched.
     * @return The index of the element or -1 if not present.
     */
    public static int binarySearch(int arr[], int n) {
        return binarySearch(arr, 0, arr.length-1, n);
    }

    /**
     * Search a sorted array by repeatedly dividing the search interval in half.
     * @param arr The sorted array to be searched.
     * @param lInd Left index for the search.
     * @param rInd Right index for the search.
     * @param n The number to be searched.
     * @return The index of the element or -1 if not present.
     */
    public static int binarySearch(int arr[], int lInd, int rInd, int n) {
        int ret = -1;
        if (rInd >= lInd) {
            int mid = lInd + (rInd - lInd) /2;

            // If the element is in the middle: found!
            if (arr[mid] == n) {
                ret = mid;
            } else {
                // If the element is below the middle, serch in the left portion
                if (n < arr[mid]) {
                    ret = binarySearch(arr, lInd, mid-1, n);
                } else { // Else, look in the right subarray
                    ret = binarySearch(arr, mid+1, rInd, n);
                }
            }
        }
        return ret;
    }
}
