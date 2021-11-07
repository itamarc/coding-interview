package io.github.itamarc;

import java.io.*;
import java.util.*;

public class PairsWithSpecDiff {
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        ArrayList<Integer[]> retArr = new ArrayList<Integer[]>();
        HashMap<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
        // for each element in the array
        for (int i = 0; i < arr.length; i++) {
            // calculate the difference from k
            // store in a hashmap with the difference as key and the corresponding value
            diffMap.put(arr[i] - k, arr[i]);
        }
        // for each element in the array
        for (int i = 0; i < arr.length; i++) {
            // look in the map if there is a pair
            if (diffMap.containsKey(arr[i])) {
                Integer[] tuple = { arr[i] + k, arr[i] };
                retArr.add(tuple);
            }
        }
        // input: arr = [0, -1, -2, 2, 1], k = 1
        // output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
        int [][] ret = new int[retArr.size()][2];
        for (int i = 0; i < retArr.size(); i++) {
            ret[i][0] = retArr.get(i)[0];
            ret[i][1] = retArr.get(i)[1];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, -2, 2, 1 };
        int[][] ret = findPairsWithGivenDifference(arr, 1);
        // int[] arr = { 1, 7, 5, 3, 32, 17, 12 };
        // Integer[][] ret = findPairsWithGivenDifference(arr, 17);
        System.out.println(Arrays.deepToString(ret));
    }
}

/*
 * Pairs with Specific Difference Given an array arr of distinct integers and a
 * nonnegative integer k, write a function findPairsWithGivenDifference that
 * returns an array of all pairs [x,y] in arr, such that x - y = k. If no such
 * pairs exist, return an empty array.
 * 
 * Note: the order of the pairs in the output array should maintain the order of
 * the y element in the original array.
 * 
 * Examples:
 * 
 * input: arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 * 
 * input: arr = [1, 7, 5, 3, 32, 17, 12], k = 17 output: [] Constraints:
 * 
 * [time limit] 5000ms
 * 
 * [input] array.integer arr
 * 
 * 0 ≤ arr.length ≤ 100 [input]integer k
 * 
 * k ≥ 0 [output] array.array.integer
 */