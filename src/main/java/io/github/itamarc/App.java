package io.github.itamarc;

import java.util.Arrays;

import io.github.itamarc.sort.QuickSort;

/**
 *
 */
public class App {
    public static void main( String[] args ) {
        DataStruct ds = new DataStruct();
        System.out.println("Original array:\n"+Arrays.toString(ds.nums));
        QuickSort.sort(ds.nums);
        System.out.println("Sorted array:\n"+Arrays.toString(ds.nums));
        int n = 27;
        System.out.println("Searching "+n+" in the array: "+Search.binarySearch(ds.nums, n));
        n = 41;
        System.out.println("Searching "+n+" in the array: "+Search.binarySearch(ds.nums, n));
        n = 411983476;
        System.out.println("Searching "+n+" in the array: "+Search.binarySearch(ds.nums, n));
        n = -41;
        System.out.println("Searching "+n+" in the array: "+Search.binarySearch(ds.nums, n));
        n = 2;
        System.out.println("Searching "+n+" in the array: "+Search.binarySearch(ds.nums, n));
    }
}
