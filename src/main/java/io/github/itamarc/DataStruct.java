package io.github.itamarc;

import java.util.ArrayList;
import java.util.Arrays;
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
        ds.multiDimArrManip();
        ds.manipSets();
        ds.manipLinkedList();
        ds.reverseLinkedList();
        ds.manipQueue();
        ds.manipMaps();
    }

    // ARRAYS
    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    int[] nums = {24, 2, 27, 49, 11, 6, 17, 18, 5, 21, 42};
    int[] sortedNums = {2, 5, 6, 11, 17, 18, 21, 24, 27, 42, 49};
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
        int[] arr = new int[5];
        System.arraycopy(nums, 0, arr, 0, arr.length);
        System.out.println("Copying nums to a array of size 5:\n"+Arrays.toString(arr));

        int[][] mulDimArr = new int[2][2];
        System.arraycopy(tuplesArr, 0, mulDimArr, 0, mulDimArr.length);
        System.out.println("Copying tuplesArr to an array of size 2:\n"+Arrays.deepToString(mulDimArr));
    }

    public void manipArrays() {
        arrList.add("Abc");
        arrList.add("Def");
        arrList.add("Ghi");
        arrList.addAll(Arrays.asList(cars));
        arrList.set(1, "Renault");
        arrList.remove("Ghi");
        arrList.remove(0);
        System.out.println("Making some manipulations on arrList:");
        System.out.println(arrList.size());
        System.out.println(arrList.toString());
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
        
        Stack<String> astack = new Stack<String>();
        while (!linkedList.isEmpty()) {
            astack.push(linkedList.removeFirst());
        }
        while (!astack.isEmpty()) {
            linkedList.add(astack.pop());
        }
        System.out.println(linkedList);
    }

    // QUEUES
    Queue<String> queueLnkdLst = new LinkedList<String>();
    /* An unbounded priority queue based on a priority heap.
     * The elements of the priority queue are ordered according to their natural ordering,
     * or by a Comparator provided at queue construction time, depending on which constructor is used.
     * A priority queue does not permit null elements.
     */
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
    Queue<String> priorityQueue = new PriorityQueue<String>();

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
        System.out.println("Map: "+map.toString());
        System.out.println("Map contains key 12? "+map.containsKey(12));
        System.out.println("Map contains key 22? "+map.containsKey(22));
        System.out.println("Map contains value 22? "+map.containsValue(22));
        System.out.println("Map contains value 12? "+map.containsValue(12));

        System.out.print("Keys: [");
        boolean first = true;
        for (int key : map.keySet()) {
            System.out.print((first ? "" : ", ")+key);
            first = false;
        }
        System.out.println("]");
    }

    // BINARY TREES

    // HEAPS

    // GRAPHS
			

    
}
