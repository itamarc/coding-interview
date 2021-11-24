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

int[] arr2 = new int[3];
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
arrList.remove(0);         // Remove index

arrList.size(); // 5

System.out.println(arrList.toString());

arrListInt.sort(Comparator.naturalOrder());
```

## Linked lists
```java
import java.util.LinkedList;
```

## Queues
```java
import java.util.PriorityQueue;
import java.util.Queue;
```

## Sets
```java
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
```

## Maps
```java
import java.util.HashMap;
import java.util.Map;
```

## Binary Trees

## Heaps

## Graphs
```java
import java.util.Stack;
```
