package io.github.itamarc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void binarySearchFound() {
        DataStruct ds = new DataStruct();
        int ind = Search.binarySearch(ds.sortedNums, 11);
        assertEquals(3, ind);
    }

    @Test
    public void binarySearchNotFound() {
        DataStruct ds = new DataStruct();
        int ind = Search.binarySearch(ds.sortedNums, 12);
        assertEquals(-1, ind);
    }

    @Test
    public void quickSort() {
        DataStruct ds = new DataStruct();
        // System.err.println(Arrays.toString(ds.nums));
        Sort.quickSort(ds.nums);        
        // System.err.println(Arrays.toString(ds.nums));
        assertTrue(Arrays.equals(ds.sortedNums, ds.nums));
    }

    @Test
    public void insertionSort() {
        DataStruct ds = new DataStruct();
        // System.err.println(Arrays.toString(ds.nums));
        Sort.insertionSort(ds.nums);        
        // System.err.println(Arrays.toString(ds.nums));
        assertTrue(Arrays.equals(ds.sortedNums, ds.nums));
    }
}
