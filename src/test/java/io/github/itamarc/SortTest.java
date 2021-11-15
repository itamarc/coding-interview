package io.github.itamarc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import io.github.itamarc.sort.HeapSort;
import io.github.itamarc.sort.InsertionSort;
import io.github.itamarc.sort.QuickSort;

public class SortTest {
    @Test
    public void quickSort() {
        DataStruct ds = new DataStruct();
        QuickSort.sort(ds.nums);        
        assertArrayEquals(ds.sortedNums, ds.nums);
    }

    @Test
    public void insertionSort() {
        DataStruct ds = new DataStruct();
        InsertionSort.sort(ds.nums);
        assertArrayEquals(ds.sortedNums, ds.nums);
    }

    @Test
    public void insertionSortRecursive() {
        DataStruct ds = new DataStruct();
        InsertionSort.sortRecursive(ds.nums, ds.nums.length-1);
        assertArrayEquals(ds.sortedNums, ds.nums);
    }

    @Test
    public void heapSort() {
        DataStruct ds = new DataStruct();
        HeapSort.sort(ds.nums);
        assertArrayEquals(ds.sortedNums, ds.nums);
    }
}
