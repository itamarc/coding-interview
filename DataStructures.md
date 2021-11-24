# Important Data Structures

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
import java.util.ArrayList;
import java.util.List;
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
import java.util.PriorityQueue; // Class
```

## Stacks

LIFO Structure

> ```[A, B, C, D, E |``` :arrow_backward: :arrow_forward:

- Used to reverse a linked list.

```java
import java.util.Stack;     // Class
```


## Sets
```java
import java.util.Set;       // Interface
import java.util.SortedSet; // Interface
import java.util.HashSet;   // Class
import java.util.TreeSet;   // Class
```

## Maps
```java
import java.util.Map;       // Interface
import java.util.HashMap;   // Class
```

## Binary Trees

### Binary Search Trees

## Heaps

### Min Heaps

### Max Heaps

## Graphs
