package io.github.itamarc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class DataStruct {
    public static void main(String[] args) {
        DataStruct ds = new DataStruct();
        ds.minAcumSum();
        ds.resizeArray();
        ds.manipArrays();
        ds.manipIntArray();
        ds.maxAndMinCombination();
        ds.multiDimArrManip();
        ds.manipSets();
        ds.manipLinkedList();
        ds.reverseLinkedList();
        ds.manipQueue();
        ds.manipStacks();
        ds.manipMaps();
        ds.manipBinaryTrees();
    }

    private void maxAndMinCombination() {
        int[] arr1 = {5, 5, 3, 9, 2};
        int[] arr2 = {3, 6, 7, 2, 1};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr1.length; i++) {
            max += max(arr1[i], arr2[arr2.length-1-i]);
            min += max(arr1[i], arr2[i]);
        }
        System.out.println("Defining max and min combinations.");
        System.out.println("max="+max);
        System.out.println("min="+min);
    }

    private int max(int i, int j) {
        return (i > j ? i : j);
    }

    // ARRAYS
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    int[] nums = {24, 2, 27, 49, 11, 6, 17, 18, 5, 21, 42};
    int[] sortedNums = {2, 5, 6, 11, 17, 18, 21, 24, 27, 42, 49};
    float[] floats = {24.1F, 2.2F, 27.3F, 49.4F, 11.5F, 6.6F, 17.7F, 18.8F, 5.9F, 21.11F, 42.12F};
    float[] sortedFloats = {2.2F, 5.9F, 6.6F, 11.5F, 17.7F, 18.8F, 21.11F, 24.1F, 27.3F, 42.12F, 49.4F};
    int[][] tuplesArr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
    int[][] multiDimArr = {{2, 5, 6, 11, 17, 18}, {21, 24, 27, 42, 49}};
    // The ArrayList class is a resizable array, which can be found in the java.util package.
    List<String> arrList = new ArrayList<String>();

    public void minAcumSum() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += sum + nums[i];
        }
        System.out.println("The sum in 'nums' is: "+sum);

        sum = 0;
        for (int i = 0; i < sortedNums.length; i++) {
            sum += sum + sortedNums[i];
        }
        System.out.println("The sum in 'sortedNums' is: "+sum);

        int[] queries = {3, 2, 1, 2, 6}; // 1, 2, 2, 3, 6
        Arrays.sort(queries);
        sum = 0;
        for (int i = 0; i < queries.length; i++) {
            int wait = 0;
            for (int j = 0; j < i; j++) {
                wait += queries[j];
            }
            sum += wait;
        }
        System.out.println("The sum in 'queries' is: "+sum);
    }

    public void resizeArray() {
        System.out.println("Original array:\n"+Arrays.toString(nums));
        int[] arr = new int[5];
        System.arraycopy(nums, 0, arr, 0, arr.length);
        System.out.println("Copying nums to a array of size 5:\n"+Arrays.toString(arr));

        int[] nums2 = Arrays.copyOf(nums, nums.length);
        System.out.println("Copying nums to a new array (Arrays.copyOf):\n"+Arrays.toString(nums2));
        
        int[][] mulDimArr = new int[2][2];
        System.arraycopy(tuplesArr, 0, mulDimArr, 0, mulDimArr.length);
        System.out.println("Copying tuplesArr to an array of size 2:\n"+Arrays.deepToString(mulDimArr));
    }

    public void manipArrays() {
        arrList.add("Abc");
        arrList.add("Def");
        arrList.add("Ghi");
        arrList.addAll(Arrays.asList(cars));
        arrList.set(1, "Renault"); // Def -> Renault
        arrList.remove("Ghi");     // Remove Object
        arrList.remove(0);         // Remove index
        System.out.println("Making some manipulations on arrList:");
        System.out.println(arrList.size());
        System.out.println(arrList.toString());
        List<String> newArrList = arrList.subList(0, arrList.size());
        System.out.println("Copy of arrList made with 'subList':\n"+newArrList.toString());

        ArrayList<Integer> arrListInt = new ArrayList<Integer>();
        arrListInt.add(3);
        arrListInt.add(2);
        arrListInt.add(5);
        arrListInt.add(1);
        arrListInt.add(4);
        System.out.println("Original arrListInt: "+arrListInt.toString());
        arrListInt.add(3, 7);
        System.out.println("arrListInt after inserting 7 on index 3: "+arrListInt.toString());
        arrListInt.remove(3);
        System.out.println("arrListInt after removing elem on index 3: "+arrListInt.toString());
        arrListInt.sort(Comparator.naturalOrder());
        System.out.println("Sorted arrListInt: "+arrListInt.toString());

        ArrayList<Integer> arrListInt2 = new ArrayList<Integer>(arrListInt);
        arrListInt2.set(0, 100);
        System.out.println("arrListInt="+arrListInt.toString());
        System.out.println("arrListInt2="+arrListInt2.toString());

        ArrayList<Integer> arrListInt3 = new ArrayList<Integer>(3);
        int ind = 0;
        try {
            arrListInt3.set(ind, 100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't set a value in index "+ind+" on a list of size "+arrListInt3.size());
        }
        Collections.addAll(arrListInt3, 100, 0, 0);
        System.out.println("arrListInt3="+arrListInt3.toString());
    }

    public void manipIntArray() {
        int[] arr = null;
        System.out.println("Int array non existent: "+Arrays.toString(arr));
        arr = new int[5];
        System.out.println("Int array non initialized: "+Arrays.toString(arr));
        Arrays.fill(arr, -1);
        System.out.println("Int array filled: "+Arrays.toString(arr));
    }

    public void multiDimArrManip() {
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                List<Integer> tuple = new ArrayList<Integer>(2);
                tuple.add(i);
                tuple.add(j);
                arrayList.add(tuple);
            }
        }
        System.out.println("Manipulating a multi dimensional array with ArrayLists:");
        System.out.println(Arrays.deepToString(arrayList.toArray()));

        System.out.println("Multidimensional array:\n"+Arrays.deepToString(tuplesArr));
    }

    // LINKED LISTS
    LinkedList<String> linkedList = new LinkedList<String>();

    public void manipLinkedList() {
        System.out.println("Manipulating a Linked List:");

        // Add
        linkedList.add("Santorini");
        linkedList.addFirst("Barcelona");
        linkedList.addLast("Tokyo");
        linkedList.add(2, "Galapagos Islands");
        System.out.println(linkedList);

        // Access
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.contains("Barcelona"));

        // Remove items
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);
        
        linkedList.remove("Santorini");
        linkedList.remove(0);
        System.out.println(linkedList);
    }

    private void reverseLinkedList() {
        System.out.println("Reversing a linked list:");
        // Add
        linkedList.add("Santorini");
        linkedList.addFirst("Barcelona");
        linkedList.addLast("Tokyo");
        linkedList.add(2, "Galapagos Islands");
        System.out.println(linkedList);
        
        Stack<String> tmpStack = new Stack<String>();
        while (!linkedList.isEmpty()) {
            tmpStack.push(linkedList.removeFirst());
        }
        while (!tmpStack.isEmpty()) {
            linkedList.add(tmpStack.pop());
        }
        System.out.println(linkedList);
    }

    // QUEUES
    Queue<String> queueLnkdLst = new LinkedList<String>();
    public void manipQueue() {
        System.out.println("Manipulating Queue:");
        queueLnkdLst.add("10");
        queueLnkdLst.add("5");
        queueLnkdLst.add("8");
        System.out.println(queueLnkdLst);
        queueLnkdLst.poll();
        System.out.println(queueLnkdLst);
        queueLnkdLst.poll();
        System.out.println(queueLnkdLst);
        System.out.println(queueLnkdLst.peek());
    }
    /* An unbounded priority queue based on a priority heap.
     * The elements of the priority queue are ordered according to their natural ordering,
     * or by a Comparator provided at queue construction time, depending on which constructor is used.
     * A priority queue does not permit null elements.
     */
    Queue<String> priorityQueue = new PriorityQueue<String>();

    // STACKS
    Stack<Integer> iStack = new Stack<Integer>();

    public void manipStacks() {
        iStack.push(1);
        iStack.push(2);
        iStack.push(5);

        System.out.println("Stack peek: "+iStack.peek());

        System.out.println("Stack pop: "+iStack.pop());
        
        System.out.println("Stack peek: "+iStack.peek());
        
        System.out.println("Search 2: "+iStack.search(2));
        System.out.println("Search 5: "+iStack.search(5));

        System.out.println("Stack: "+iStack);
    }

    // SETS
    /* The set interface is present in java.util package and extends the Collection interface
     * is an unordered collection of objects in which duplicate values cannot be stored.
     */
    Set<String> set = new HashSet<String>();
    SortedSet<String> sortedSet = new TreeSet<String>();

    public void manipSets() {
        System.out.println("Manipulating SETS:");
        set.add("Aaa");
        set.add("Bbb");
        set.add("Ccc");
        System.out.println(set);
        set.add("Ccc");
        System.out.println(set);
        System.out.println((set.contains("Bbb") ? "Set contains 'Bbb'" : "Set doesn't contain 'Bbb'"));
        System.out.println("Removing 'Bbb'...");
        set.remove("Bbb");
        System.out.println(set);
        System.out.println((set.contains("Bbb") ? "Set contains 'Bbb'" : "Set doesn't contain 'Bbb'"));
    }

    // MAPS
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void manipMaps() {
        map.put(10, 20);
        map.put(11, 21);
        map.put(12, 22);
        map.put(13, 23);
        map.put(14, 24);
        map.remove(14);
        map.put(13, 123);
        System.out.println("Map: "+map.toString());
        System.out.println("Map contains key 12? "+map.containsKey(12));
        System.out.println("Map contains key 22? "+map.containsKey(22));
        System.out.println("Map contains value 22? "+map.containsValue(22));
        System.out.println("Map contains value 12? "+map.containsValue(12));

        System.out.println("Element with key 13: "+map.get(13));

        System.out.print("Keys: [");
        boolean first = true;
        for (int key : map.keySet()) {
            System.out.print((first ? "" : ", ")+key);
            first = false;
        }
        System.out.println("]");

        System.out.print("Values: [");
        first = true;
        for (int value : map.values()) {
            System.out.print((first ? "" : ", ")+value);
            first = false;
        }
        System.out.println("]");
    }

    // BINARY TREES
    public void manipBinaryTrees() {
        System.out.println("Manipulating Binary Trees:");
        BinaryTree<Integer> root = new BinaryTree<Integer>(1);
        root.insertLeft(2);
        root.insertRight(3);
    }

    // HEAPS

    // GRAPHS
			

    
}
