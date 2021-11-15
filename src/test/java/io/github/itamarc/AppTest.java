package io.github.itamarc;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
