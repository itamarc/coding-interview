# Important Algorithms

### Bubble sort

Bubble Sort is the simplest sorting algorithm that works by
repeatedly swapping the adjacent elements if they are in wrong order,
in consecutive passes, until a whole pass is made without any swap.

Time Complexity:
- O(n²) in the average and worst cases
- O(n) in the best case

```java
public static void sort(int[] array) {
    boolean unsorted = true;
    while (unsorted) {
        unsorted = false;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                swap(array, i, i+1);
                unsorted = true;
            }
        }
    }
}
```

### Insertion sort

The insertion sort algorithm pick each element from the array and if it's not 
in the correct position, it's moved to the left until it's in the correct order.

This algorithm starts with the two first elements and at each iteration it
look the next element, increasing the working array until process all the array.
At each step, all the elements to the left of the current element are sorted.

The algorithm is O(n²) in worst case and O(n) in best case.

```java
public static void sort(int[] array) {
    int ind = 1;
    while (ind < array.length) {
        int curr = ind;
        while (curr > 0 && array[curr-1] > array[curr]) {
            swap(array, curr, curr-1);
            curr--;
        }
        ind++;
    }
}
```

#### Recursive

```java
public static void insertionSortRecursive(int[] array, int rightIndex) {
    if (rightIndex > 0) {
        insertionSortRecursive(array, rightIndex-1);
        int x = array[rightIndex];
        int j = rightIndex-1;
        while (j >= 0 && array[j] > x) {
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = x;
    }
}
```

## Sorting

### Quick sort

Quicksort is a type of **divide and conquer** algorithm for sorting an array, based on a
partitioning routine; the details of this partitioning can vary somewhat, so that 
quicksort is really a family of closely related algorithms.

#### The steps for in-place quicksort are:

1. If the range has **less than two elements, return** immediately as there is nothing to do. Possibly for other very short lengths a special-purpose sorting method is applied and the remainder of these steps skipped.
2. Otherwise **pick a value**, called a **pivot**, that occurs in the range (the precise manner of choosing depends on the partition routine, and can involve randomness).
3. **Partition the range**: reorder its elements, while determining a point of division, so that all elements with values **less than the pivot come before the division**, while all elements with values **greater than the pivot come after it**; elements that are equal to the pivot can go either way. Since at least one instance of the pivot is present, most partition routines ensure that the value that ends up at the point of division is equal to the pivot, and is now in its final position (but termination of quicksort does not depend on this, as long as sub-ranges strictly smaller than the original are produced).
4. **Recursively apply** the quicksort to the **sub-range up to the point of division** and to the **sub-range after it**, possibly excluding from both ranges the element equal to the pivot at the point of division. (If the partition produces a possibly larger sub-range near the boundary where all elements are known to be equal to the pivot, these can be excluded as well.)

Time Complexity:
- O(n²) in the worst case
- O(n log n) in the average and best cases

Space Complexity:
- O(n) in the worst case
- O(log n) in the average and best cases

### Merge sort

Conceptually, a merge sort works as follows:
- **Divide** the unsorted list into **n sublists**, each containing **one element** (a list of one element is considered sorted).
- **Repeatedly merge sublists** to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.

Time Complexity:
- O(n log n) in the average and worst cases

Space Complexity:
- O(n) in the worst case

## Searching

### Linear search

Consists in iterating over the list to find the desired element.

The list does not need to be sorted.

Time Complexity:
- O(n) in the average and worst cases
- O(1) in the best case

Space Complexity:
- O(1)

### Binary search

- The list must be sorted.
- Iterative or recursive

Time complexity:
- O(log n) in the average and worst cases
- O(1) in the best case

Space complexity:
- O(1) in the iterative method
- O(log n) in the recursive method

```java
// Returns index of key if found, else -1
public static int binarySearch(int array[], int leftIndex, int rightIndex, int target) {
    int result = -1;
    if (leftIndex <= rightIndex) {
        int mid = leftIndex + (rightIndex - leftIndex) / 2;

        // If the element is in the middle: found!
        if (array[mid] == target) {
            result = mid;
        } else {
            // If the element is below the middle value, search in the left portion
            if (target < array[mid]) {
                result = binarySearch(array, leftIndex, mid-1, target);
            } else { // Else, look in the right subarray
                result = binarySearch(array, mid+1, rightIndex, target);
            }
        }
    }
    return result;
}
```

## Divide-and-conquer

## Greedy algorithms

## Recursion

A common method of simplification is to divide a problem into subproblems of the same type.

Such problems can generally be solved by iteration, but this needs to identify and index the smaller instances at programming time.
Recursion solves such recursive problems by using functions that call themselves from within their own code.

Example:

```java
int factorial(int n) {
    if (n <= 0) {
        return 1;
    } else {
        return factorial(n-1)*n;
    }
}
```

## Graph traversal

### Concepts

In mathematics, and more specifically in graph theory, a graph is a structure 
amounting to a set of objects in which some pairs of the objects are in some 
sense "related". The objects correspond to mathematical abstractions called 
vertices (also called nodes or points) and each of the related pairs of 
vertices is called an edge (also called link or line).

- The edges may be directed or undirected.

### Breadth-first

```java
class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    // Return a list of the Nodes names in order of the breadth-first traversal
    public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                // This can be a different action, like returning
                // true if the target is found:
                array.add(curr.name);

                for (int i=0; i<curr.children.size(); i++) {
                    queue.add(curr.children.get(i));
                }
            }
        return array;
    }
}
```

### Depth-first

- Usually recursive, but can be implemented iteratively with a stack.

```java
class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    // Return a list of the Nodes names in order of the depth-first traversal
    public List<String> depthFirstSearch(List<String> array) {
        array.add(name);
        Iterator iter = children.iterator();
        while (iter.hasNext()) {
            Node child = (Node)iter.next();
            child.depthFirstSearch(array);
        }
        return array;
    }
}
```

### Cycle detection

This may not be the optimal solution, bit it's mine and works.

```java
// Each element in the array corresponds to a node in the graph and
// have a list of the nodes that are adjacent to it. Directional graph.
int[][] edges = {
    {1},
    {2, 3},
    {0, 4},
    {},
    {3}
};

public boolean cycleInGraph(int[][] edges) {
    boolean hasCycle = false;
    for (int i=0; i<edges.length; i++) {
        Stack<Integer> history = new Stack<Integer>();
        if (detectCycle(edges, i, i, history)) {
            hasCycle = true;
            break;
        }
    }
    return hasCycle;
}

private boolean detectCycle(int[][] edges, int vertex, int target, Stack<Integer> history) {
    boolean cycle = false;
    for (int i=0; i<edges[vertex].length; i++) {
        if (edges[vertex][i] == target) {
            return true;
        }
        if (history.search(edges[vertex][i]) > 0) {
            return true;
        }
        history.push(edges[vertex][i]);
        cycle = cycle || detectCycle(edges, edges[vertex][i], target, history);
        history.pop();
    }
    return cycle;
}
```

#### Tree

A tree is an undirected graph in which any two vertices are connected by exactly one path, or equivalently a connected acyclic undirected graph.

##### Tree traversal

For binary trees, the depth-first traversal can be made in three ways:

###### InOrder

left, **root**, right

###### PreOrder

**root**, left, right

###### PostOrder

left, right, **root**

## Sliding window technique

:warning:

## Invert a binary tree

Simple recursive method:

```java
public static void invertBinaryTree(BinaryTree tree) {
    BinaryTree tmp = tree.left;
    tree.left = tree.right;
    tree.right = tmp;
    
    if (tree.left != null) {
        invertBinaryTree(tree.left);
    }
    if (tree.right != null) {
        invertBinaryTree(tree.right);
    }
}
```

## Reverse a linked list

We traverse the linked list putting the nodes in a stack.
Then, we pop the nodes from the stack and put them back in the linked list.
The nodes will be in the reverse order.

```java
public static void reverse(LinkedList<T> linkedList) {
    Stack<T> tmpStack = new Stack<T>();
    while (!linkedList.isEmpty()) {
        tmpStack.push(linkedList.removeFirst());
    }
    while (!tmpStack.isEmpty()) {
        linkedList.add(tmpStack.pop());
    }
}
```

## Suffix tree

In computer science, a suffix tree (also called PAT tree or, in an earlier
form, position tree) is a compressed trie containing all the suffixes of the
given text as their keys and positions in the text as their values. Suffix
trees allow particularly fast implementations of many important string
operations.

:warning:

## Heaps

Heap is a data structure that satisfies the heap property:
- The heap is a complete binary tree.
- The parent node is always greater than or equal to its children (Max Heap) or smaller than or equal (Min Heap).
- The root node is always the greatest element in the heap (Max Heap) or the smallest (Min Heap).

When the Heap is stored in an array, you can access the parent node by using the formula:
- parent = ```floor( (i - 1) / 2 )```

And the children by using the formulas:
- left = ```2 * i + 1```
- right = ```2 * i + 2```

To insert a node:
- Add the node to the end of the list.
- Compare the node with its parent.
- If the parent is smaller, swap the nodes.
- Continue until the node is in the correct position.

To remove **the root node**:
- Swap the root node with the last node.
- Remove the last node.
- Compare the root node with its smaller child.
- If the child is smaller, swap the nodes.
- Continue until the node is in the correct position.

## Dynamic programming and memorization
