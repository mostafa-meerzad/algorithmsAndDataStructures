# Data Structures and Algorithms

## The big O notation

### The Traditional explanation

Big O is a mathematical notation that describes the limiting behavior of a function when the argument tends towards a particular value or infinity.

### The Better way

We use Big O to describe the performance of an algorithm!

which helps us determine if an algorithm is scalable or not, in other words is the algorithm going to perform well when the input grows

### O(1)

O(1) represents "constant time complexity," meaning that the time it takes to run an operation does not depend on the size of the input. An O(1) operation will always take the same amount of time regardless of how large the input is.

#### Example 1: Accessing an Array.LearningArray Element

Accessing an element in an array by index is O(1) because the time required to retrieve the element does not depend on the size of the array.

**Java example:**

```java
public class ConstantTimeExample {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        int element = numbers[2];  // O(1) operation
        System.out.println("Element at index 2 is: " + element);
    }
}
```

In this example, retrieving `numbers[2]` takes constant time, O(1), regardless of the array's size.

## O(n)

O(n), or "linear time complexity," means that the time it takes to complete the operation grows linearly with the size  of the input. In an O(n) operation, if the input doubles, the time required to process it also roughly doubles.

### Example 1: Summing All Elements in an Array.LearningArray

Summing all elements in an array is an O(n) operation because we need to go through each element exactly once to
calculate the total.

**Java example:**

```java
public class LinearTimeExample {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        int sum = 0;

        // O(n) operation, iterating through each element
        for (int number : numbers) {
            sum += number;
        }

        System.out.println("Sum of array elements: " + sum);
    }
}
```

In this example, the `for` loop iterates over each element in the array, making this an O(n) operation. The time taken
grows proportionally with the array's size.

### Example 2: Linear Search in an Array.LearningArray

Finding an element in an unsorted array requires a linear search, where we check each element one by one until we find
the target or reach the end of the array.

**Java example:**

```java
public class LinearSearchExample {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        int target = 8;
        boolean found = false;

        // O(n) operation, iterating to find the target
        for (int number : numbers) {
            if (number == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Target found!");
        } else {
            System.out.println("Target not found.");
        }
    }
}
```

In this example, finding the target element is an O(n) operation because, in the worst case, we may have to check every
element.

## O(n²)

O(n²), or **quadratic time complexity**, indicates that the time required to complete an algorithm grows proportionally
to the square of the input size, \( n \). This means if the input size doubles, the time taken will roughly quadruple.
Quadratic time complexity usually arises from algorithms with **nested loops**, where one loop iterates over all
elements, and another loop (nested inside the first) iterates over each element as well.

### Why O(n²) Occurs

In an O(n²) algorithm, each element may interact with every other element in the input, leading to a significant
increase in runtime as the input size grows. This often happens in operations that require comparing every element to
every other element, as in sorting algorithms like Bubble Sort or Selection Sort.

### Example 1: Nested Loops

Consider a simple example with two nested `for` loops that each iterate over the same list:

```java
public class QuadraticTimeExample {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {         // Outer loop (O(n))
            for (int j = 0; j < n; j++) {     // Inner loop (O(n))
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }
}
```

Here’s the breakdown:

- The **outer loop** runs \( n \) times.
- For each iteration of the outer loop, the **inner loop** also runs \( n \) times.

Since the inner loop runs completely for every single pass of the outer loop, we multiply their complexities:
\[
O(n) \times O(n) = O(n^2)
\]

### Example 2: Checking for Duplicate Pairs

In some cases, you may want to check every pair of elements in an array to find duplicates. This would also result in an
O(n²) complexity:

```java
public class DuplicatePairsExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Nested loop to check each pair
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println("Duplicate found: " + numbers[i]);
                }
            }
        }
    }
}
```

- The **outer loop** runs \( n \) times.
- The **inner loop** also runs up to \( n-1 \) times in the worst case.

This means that as the input grows, the time taken to complete this operation grows quadratically. So the time
complexity is **O(n²)**.

### Characteristics of O(n²) Algorithms

1. **Nested Iterations**: Usually, O(n²) complexity arises when a loop is nested within another loop, both iterating
   over the input size.
2. **Exponential Growth in Time**: As the input size increases, the runtime grows at a much faster rate (quadratically).
3. **Common in Basic Algorithms**: Algorithms like Bubble Sort, Selection Sort, and Insertion Sort have O(n²)
   complexity.

### Practical Implications

Quadratic time complexity can be manageable for small input sizes but becomes impractical for large inputs. If possible,
it’s often beneficial to find more efficient algorithms, such as those with **O(n log n)** complexity for sorting, to
handle larger data more efficiently.

## O(log(n))

O(log(n)), or **logarithmic time complexity**, means that the time an algorithm takes grows logarithmically relative to
the input size. This is much more efficient than O(n) because the number of operations needed grows very slowly as the
input size increases. In an O(log(n)) algorithm, doubling the input size only adds a small, constant number of
additional operations.

### When O(log(n)) Occurs

Logarithmic time complexity typically occurs in algorithms where the input is repeatedly **halved** or divided in some
way during each step. This is common in operations on **sorted data structures** or in algorithms that follow a **divide
and conquer** approach, like binary search.

### Example 1: Binary Search

Binary search is a classic example of an O(log(n)) algorithm. It works on a sorted array by repeatedly dividing the
search range in half until the target element is found (or the range is empty).

**How it works:**

1. Start with the entire array.
2. Check the middle element.
3. If the middle element is the target, stop.
4. If the target is smaller than the middle element, repeat the search in the left half.
5. If the target is larger, repeat the search in the right half.
6. This halving continues until the target is found or no elements are left.

**Java example:**

```java
public class BinarySearchExample {
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the midpoint

            if (sortedArray[mid] == target) {
                return mid;  // Target found
            } else if (sortedArray[mid] < target) {
                left = mid + 1;  // Search the right half
            } else {
                right = mid - 1;  // Search the left half
            }
        }

        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int result = binarySearch(numbers, target);

        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
    }
}
```

Here’s the breakdown:

- At each step, binary search reduces the number of elements it’s searching by half.
- If the array has \( n \) elements, binary search will take approximately \( \log_2(n) \) steps to complete.

Thus, the time complexity of binary search is **O(log(n))**.

### Example 2: Balanced Binary Search Trees (BST)

In a balanced binary search tree, searching, inserting, and deleting elements also have a time complexity of O(log(n))
on average. This is because each step in these operations navigates down one level of the tree, halving the remaining
nodes to examine.

### Characteristics of O(log(n)) Complexity

1. **Dividing the Problem in Half**: Logarithmic time complexity often occurs when each step reduces the problem size by
   a constant fraction (like half).
2. **Efficient for Large Inputs**: O(log(n)) is highly efficient for large inputs since the number of required
   operations grows very slowly.
3. **Common in Search Algorithms**: Algorithms like binary search and operations on balanced trees (e.g., AVL trees,
   Red-Black trees) are O(log(n)).

### Practical Implications

Algorithms with O(log(n)) complexity are highly scalable and perform well even on large datasets, as the number of steps
grows slowly relative to the input size.

## O(2^n)

O(2^n), or **exponential time complexity**, means that the time required by an algorithm grows exponentially as the
input size increases. Specifically, as the input size \( n \) grows, the number of operations doubles with each
additional element. This results in very rapid growth, making exponential algorithms impractical for large input sizes.

### When O(2^n) Occurs

Exponential time complexity usually arises in algorithms that solve problems by exploring all possible combinations,
especially when making binary (yes/no) choices at each step. This commonly occurs in problems involving **recursion with
multiple branches** (like exhaustive searches), where each step potentially branches into two or more recursive calls.

### Example 1: Fibonacci Sequence (Naive Recursive Approach)

Calculating the Fibonacci sequence recursively without memoization is a classic example of O(2^n) time complexity. In
this approach, each function call results in two recursive calls, leading to a "tree" of recursive calls that grows
exponentially.

**Java example:**

```java
public class FibonacciExample {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
```

Here’s the breakdown:

- Each call to `fibonacci(n)` leads to two additional calls: `fibonacci(n - 1)` and `fibonacci(n - 2)`.
- This results in a "tree" structure of recursive calls, where the number of calls doubles with each increase in \(
  n \).

For example, computing `fibonacci(5)` will lead to the following calls:

```
fibonacci(5)
├── fibonacci(4)
│   ├── fibonacci(3)
│   │   ├── fibonacci(2)
│   │   │   ├── fibonacci(1)
│   │   │   └── fibonacci(0)
│   │   └── fibonacci(1)
│   └── fibonacci(2)
│       ├── fibonacci(1)
│       └── fibonacci(0)
└── fibonacci(3)
    ├── fibonacci(2)
    │   ├── fibonacci(1)
    │   └── fibonacci(0)
    └── fibonacci(1)
```

For each additional level, the number of calls roughly doubles, resulting in O(2^n) time complexity.

### Example 2: Subset/Combination Generation

When generating all possible subsets or combinations of a set, an algorithm with O(2^n) complexity is often required.
For example, if we need to find all subsets of an array, each element has two choices: to be included in a subset or
not, resulting in 2^n possible subsets.

```java
public class SubsetExample {
    public static void generateSubsets(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        // Exclude the first character
        generateSubsets(prefix, remaining.substring(1));

        // Include the first character
        generateSubsets(prefix + remaining.charAt(0), remaining.substring(1));
    }

    public static void main(String[] args) {
        String input = "abc";
        generateSubsets("", input);
    }
}
```

For an input of length \( n \), this generates \( 2^n \) subsets (since each character has two options: include or
exclude).

### Characteristics of O(2^n) Complexity

1. **Rapid Growth**: Exponential algorithms grow very quickly, making them impractical for large inputs.
2. **Common in Exhaustive Searches**: Problems like the traveling salesman problem, subset generation, and certain
   recursive algorithms fall into O(2^n) due to the need to explore many possible combinations.
3. **Inefficiency**: Exponential time complexity is only manageable for small inputs, as even moderate input sizes lead
   to prohibitively large runtimes.

### Practical Implications

Algorithms with O(2^n) are typically avoided for large inputs. Instead, strategies like **dynamic programming** and *
*memoization** can sometimes reduce exponential complexity (e.g., from O(2^n) to O(n) for the Fibonacci problem) by
avoiding redundant calculations.

## Space Complexity of algorithms

Space complexity is a measure of the amount of memory an algorithm needs to run, relative to the input size. Just like
time complexity, it’s an important factor to consider in designing efficient algorithms, especially when memory
resources are limited.

### What is Space Complexity?

Space complexity calculates the extra space or memory an algorithm requires. It includes:

1. **Fixed Part**: This is space required regardless of input size, such as space for:
    - Constants
    - Variable storage (e.g., counters, accumulators)
    - Temporary storage for results

2. **Variable Part**: This depends on the input size and may change as the input grows. It includes:
    - Memory needed for dynamically allocated space (like arrays or data structures that grow with input)
    - Space for recursion or stack space

So, in simple terms, space complexity includes all the memory used by the algorithm: from storing variables to
maintaining the call stack in recursive functions.

### Space Complexity Notations

- **O(1)**: Constant space. The algorithm uses a fixed amount of space regardless of input size.
- **O(n)**: Linear space. Memory usage grows linearly with input size.
- **O(n^2)**: Quadratic space. Memory usage grows with the square of the input size.

### Example of Space Complexity

Consider a function to calculate the sum of an array. Here’s how we analyze its space complexity:

```java
public class ArraySum {
    public static int sumArray(int[] arr) {
        int total = 0;  // O(1) space for the integer 'total'
        for (int number : arr) {
            total += number;  // O(1) space for 'number' in each iteration
        }
        return total;
    }
}

```

The space complexity here is **O(1)** because we only need a fixed amount of space to store the variable `total`, no
matter the size of the array `arr`. We are not creating any extra structures or recursive calls, so memory usage remains
constant.

### Example of Higher Space Complexity: Recursion

Consider the Fibonacci sequence using recursion:

```java
import java.util.Arrays;

public class ArrayCopy {
    public static int[] copyArray(int[] arr) {
        int[] copiedArray = new int[arr.length];  // O(n) space for the new array
        for (int i = 0; i < arr.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }
}

```

For each recursive call, a new stack frame is created. If `n` is large, the call stack can grow up to `O(n)`, so this
recursive function has **O(n)** space complexity due to the recursion depth.

```java
import java.util.Arrays;

public class ArrayCopy {
    public static int[] copyArray(int[] arr) {
        int[] copiedArray = new int[arr.length];  // O(n) space for the new array
        for (int i = 0; i < arr.length; i++) {
            copiedArray[i] = arr[i];
        }
        return copiedArray;
    }
}
```

### Why Space Complexity Matters

Understanding space complexity is crucial in scenarios where memory is a constraint, like embedded systems, mobile
devices, or when working with large datasets. Efficient algorithms optimize both time and space to make best use of
available resources.