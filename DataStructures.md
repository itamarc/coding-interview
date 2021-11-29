# Important Data Structures

## Collections

**General purpose implementations**

| Interface    | Hash Table | Resizable Array | Balanced Tree | Linked List | Hash Table + Linked List |
|---|---|---|---|---|---|
| Set          | HashSet    |                 | TreeSet       |             | LinkedHashSet |
| List         |            | ArrayList       |               | LinkedList  | |
| Queue, Deque |            | ArrayDeque      |               | LinkedList  | |
| Map          | HashMap    |                 | TreeMap       |             | LinkedHashMap |

Source: [Collections Framework Overview](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/doc-files/coll-overview.html)

**Common data structures and their methods**

| Interface | Insertion | Removal | Retrieval | Search | Length |
|---|---|---|---|---|---|
| Set  | .add(E e) | .remove(Object o) | - | .contains(Object o) | .size() <br/> .isEmpty() |
| List | .add(E e) <br/> .add(int idx, E e) | .remove(E e) <br/> .remove(int idx) | .get(int idx) | .contains(Object o) | .size() <br/> .isEmpty() |
| Queue | .add(E e) | .poll() | .poll() <br/> .peek() | .contains(Object o) | .size() <br/> .isEmpty() |
| Deque | .addFirst(E e) <br/> .addLast(E e) | .pollFirst() <br/> .pollLast() | .peekFirst() <br/> .peekLast() <br/> .peek() | .contains(Object o) | .size() <br/> .isEmpty() |
| Stack¹ | .push(E e) | .pop() | .peek() | .search(Object o) | .size() <br/> .isEmpty() |
| Map | .put(K key, V value) | .remove(Object key) | .get(Object key) | .containsKey(Object k) <br/> .containsValue(Object v) | .size() <br/> .isEmpty() |

¹ It's a class implementing the List interface and a subclass of Vector.

## Arrays

Primitive arrays are arrays of numbers, strings, or booleans.
java.util.Arrays is a class with static methods for sorting and searching arrays.

```java
import java.util.Arrays;

int[] arr1 = {5, 5, 3, 9, 2};
arr1.length; // 5
Arrays.sort(arr1);
System.out.println("Sorted int array: "+Arrays.toString(arr1));

int[][] tuplesArr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
System.out.println("Multidimensional array: "+Arrays.deepToString(tuplesArr));

int[] arr2 = new int[3]; // Initially this will be {0, 0, 0}
System.arraycopy(arr1, 0, arr2, 0, arr2.length);
// Same as:
arr2 = Arrays.copyOf(arr1, arr2.length);
```

The package java.util have several classes for manipulating data structures.

```java
import java.util.List;       // Interface
import java.util.ArrayList;  // Class
import java.util.Comparator;

List<String> arrList = new ArrayList<String>();
arrList.add("Abc");
arrList.add("Def");
arrList.add("Ghi");

String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
arrList.addAll(Arrays.asList(cars));

arrList.set(1, "Renault"); // Def -> Renault
arrList.remove("Ghi");     // Remove Object
arrList.remove(0);         // Remove "Abc" by index

arrList.size(); // 5

System.out.println(arrList.toString());

arrListInt.sort(Comparator.naturalOrder());
```

## Linked lists
```java
import java.util.LinkedList;    // Class, double-linked list
```

## Queues

FIFO Structure

> :arrow_forward: ```| A, B, C, D, E |``` :arrow_forward:

- Used to traverse a tree or graph in a breadth-first manner.

```java
import java.util.Queue;         // Interface
import java.util.LinkedList;    // Class, implements Queue
import java.util.PriorityQueue; // Class

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
```
Output:
```
Manipulating Queue:
[10, 5, 8]
[5, 8]    
[8]       
8
```


## Stacks

LIFO Structure

> ```[A, B, C, D, E |``` :arrow_backward: :arrow_forward:

- Used to reverse a linked list.

```java
import java.util.Stack;     // Class

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
```
Output:
```
Stack peek: 5
Stack pop: 5
Stack peek: 2
Search 2: 1
Search 5: -1
Stack: [1, 2]
```


## Sets
```java
import java.util.Set;       // Interface
import java.util.SortedSet; // Interface
import java.util.HashSet;   // Class
import java.util.TreeSet;   // Class

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
```
Output:
```
Manipulating SETS:
[Aaa, Ccc, Bbb]   
[Aaa, Ccc, Bbb]   
Set contains 'Bbb'
Removing 'Bbb'...
[Aaa, Ccc]
Set doesn't contain 'Bbb'
```

## Maps
```java
import java.util.Map;       // Interface
import java.util.HashMap;   // Class

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
```
Output:
```
Map: {10=20, 11=21, 12=22, 13=123}
Map contains key 12? true
Map contains key 22? false
Map contains value 22? true
Map contains value 12? false
Element with key 13: 123
Keys: [10, 11, 12, 13]
Values: [20, 21, 22, 123]
```

## Graphs

In mathematics, and more specifically in graph theory, a graph is a structure 
amounting to a set of objects in which some pairs of the objects are in some 
sense "related". The objects correspond to mathematical abstractions called 
vertices (also called nodes or points) and each of the related pairs of 
vertices is called an edge (also called link or line).

- The edges may be directed or undirected.

class Graph {
    int V;               // Number of vertices
    List<Integer> adj[]; // Adjacency list
}

## Trees

In graph theory, a tree is an undirected graph in which any two vertices are
connected by exactly one path, or equivalently a connected acyclic undirected
graph.

In computer science, a tree is a widely used abstract data type that simulates
a hierarchical tree structure, with a root value and subtrees of children with
a parent node, represented as a set of linked nodes.

## Binary Trees

A tree with only two children for each node.

```java
class Node {
    int data; // The node can have any kind of data
    Node left;
    Node right;
}
```

### Binary Search Trees

In computer science, a binary search tree (BST), also called an ordered or
sorted binary tree, is a rooted binary tree data structure whose internal nodes
each store a key greater than all the keys in the node’s left subtree and less
than those in its right subtree.

## Heaps

Heap is a data structure that satisfies the heap property:
- The heap is a complete binary tree.
- The parent node is always greater than or equal to its children (Max Heap) or smaller than or equal (Min Heap).
- The root node is always the greatest element in the heap (Max Heap) or the smallest (Min Heap).

### Min Heaps

- The parent node is always smaller than or equal to its children.
- The root node is always the smallest element in the heap.

### Max Heaps

- The parent node is always greater than or equal to its children.
- The root node is always the greatest element in the heap.

## Tries

In computer science, a trie, also called digital tree or prefix tree, is a type
of search tree, a tree data structure used for locating specific keys from
within a set. These keys are most often strings, with links between nodes
defined not by the entire key, but by individual characters. In order to access
a key (to recover its value, change it, or remove it), the trie is traversed
depth-first, following the links between nodes, which represent each character
in the key.

## Suffix tree

In computer science, a suffix tree (also called PAT tree or, in an earlier
form, position tree) is a compressed trie containing all the suffixes of the
given text as their keys and positions in the text as their values. Suffix
trees allow particularly fast implementations of many important string
operations.
