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
     * @param array The sorted array to be searched.
     * @param leftIndex Left index for the search.
     * @param rightIndex Right index for the search.
     * @param target The number to be searched.
     * @return The index of the element or -1 if not present.
     */
    public static int binarySearch(int array[], int leftIndex, int rightIndex, int target) {
        int result = -1;
        if (rightIndex >= leftIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) /2;

            // If the element is in the middle: found!
            if (array[mid] == target) {
                result = mid;
            } else {
                // If the element is below the middle, serch in the left portion
                if (target < array[mid]) {
                    result = binarySearch(array, leftIndex, mid-1, target);
                } else { // Else, look in the right subarray
                    result = binarySearch(array, mid+1, rightIndex, target);
                }
            }
        }
        return result;
    }
}
