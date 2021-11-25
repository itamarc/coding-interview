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

### Binary search

- Recursive

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
            // If the element is below the middle value, serch in the left portion
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

:warning:

## Graph traversal

### Breadth-first

:warning:

### Depth-first

:warning:

- Usually recursive, but can be implemented iteratively with a stack.

#### InOrder

left, **root**, right

#### PreOrder

**root**, left, right

#### PostOrder

left, right, **root**

### Cycle detection

:warning:

## Sliding window technique

:warning:

## Invert a binary tree

:warning:

## Reverse a linked list

:warning:

## Suffix tree

:warning:

## Heaps

:warning:

## Dynamic programming and memorization
