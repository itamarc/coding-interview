package io.github.itamarc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DataStruct {
    public static void main(String[] args) {
        DataStruct ds = new DataStruct();
        ds.resizeArray();
    }
    // ARRAYS
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    int[] nums = {24, 2, 27, 49, 11, 6, 17, 18, 5, 21, 42};
    int[] sortedNums = {2, 5, 6, 11, 17, 18, 21, 24, 27, 42, 49};
    int[][] tuplesArr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    int[][] multiDimArr = {{2, 5, 6, 11, 17, 18}, {21, 24, 27, 42, 49}};
    // The ArrayList class is a resizable array, which can be found in the java.util package.
    ArrayList<String> arrList = new ArrayList<String>();

    public void resizeArray() {
        int[] arr = new int[5];
        System.arraycopy(nums, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

        int[][] mulDimArr = new int[2][2];
        System.arraycopy(tuplesArr, 0, mulDimArr, 0, mulDimArr.length);
        System.out.println(Arrays.deepToString(mulDimArr));
    }

    public void manipArrays() {
        arrList.add("Abc");
        arrList.add("Def");
        arrList.add("Ghi");
        arrList.addAll(Arrays.asList(cars));
        arrList.set(1, "Renault");
        System.out.println(arrList.size());
        System.out.println(arrList.toString());
    }

    public void multiDimArrManip() {
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                ArrayList<Integer> tuple = new ArrayList<Integer>(2);
                tuple.add(i);
                tuple.add(j);
                arrayList.add(tuple);
            }
        }
        System.out.println(Arrays.deepToString(arrayList.toArray()));
    }

    // LINKED LISTS
    LinkedList<String> linkedList = new LinkedList<String>();

    // QUEUES
    Queue<String> queueLnkdLst = new LinkedList<String>();
    /* An unbounded priority queue based on a priority heap.
     * The elements of the priority queue are ordered according to their natural ordering,
     * or by a Comparator provided at queue construction time, depending on which constructor is used.
     * A priority queue does not permit null elements.
     */
    Queue<String> priorityQueue = new PriorityQueue<String>();

    // SETS
    /* The set interface is present in java.util package and extends the Collection interface
     * is an unordered collection of objects in which duplicate values cannot be stored.
     */
    Set<String> set = new HashSet<String>();
    SortedSet<String> sortedSet = new TreeSet<String>();

    // MAPS
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // BINARY TREES

    // HEAPS

    // GRAPHS
    
}
