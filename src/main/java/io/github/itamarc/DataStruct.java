package io.github.itamarc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DataStruct {
    // ARRAYS
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    int[] nums = {2, 5, 6, 11, 17, 18, 21, 24, 27, 42, 49};
    int[][] multiDimArr = {{2, 5, 6, 11, 17, 18}, {21, 24, 27, 42, 49}};
    // The ArrayList class is a resizable array, which can be found in the java.util package.
    ArrayList<String> arrList = new ArrayList<String>();

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

    // BINARY TREES

    // HEAPS

    // GRAPHS
    
}
