# LearningArray

Arrays store list of items sequentially
If you want to store a list of elements and access them by their index Arrays are the best option for you

1. accessing elements of an array using their index is `O(1)`

2. inserting elements  `O(n)`

   in java and some other languages arrays are static, and we must specify the size of array ahead of time by guessing

    - oversize: we wast memory for the empty locations
    - undersized: we can't store the rest of elements which means we need to move elements into a larger array! `O(n)`

   e.x: we have a 5 item array and need to add a 6th element! now we need to move all 6 elements to a new and larger
   array with 6 elements. the `run time complexity` of this operation grows linearly with direct proportion to the size
   of the array `O(n)`

3. deleting an element

    - if the element is at the end of array `O(1)` in determining the time complexity of an algorithm think about
      the `worst case scenario`, removing an element from the end of an array is the `best case scenario`
    - if we remove the element form the beginning of an array then we have to shift all the remaining element one step
      to the left `O(n)` `worst case scenario` the more elements we have the more operations for shifting!

```java

public class LearningArray {

    public static void main(String[] args) {
        // arrayDataType[] arrayName = new arrayDataType[numberOfElements]
        int[] numbers = new int[3];

        System.out.println(numbers);
        // the output in the terminal "[I@7b23ec81" which is a combination of array-data-type "[I" followed by "@" and the number generated based on the address of this object in the memory "7b23ec81"
    }
}


```

If you run the code about the result `[I@7b23ec81` is not useful instead you should use `Arrays` class to get the array
value

## Adding Individual Elements

```java
public class LearningArray {

    public static void main(String[] args) {
        int[] numbers = new int[3];
        // adding elements individually
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers));
    }
}

```

## Adding All Elements in One Go

```java
import java.util.Arrays;

public class LearningArray {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        // getting the number of elements
        System.out.println(numbers.length);
        System.out.println(Arrays.toString(numbers));
    }
}

```

## Exercise:1 Create a Dynamic Array

Implement an Array Class that takes the length of the array as an argument, then we can insert new elements, remove
elements and print all the elements of the array.

**Note**: this array class should not do anything with printing content in the console or anything related to that, but
here we want to learn and improve problem-solving skills.

**Note**: Break down the problem into smaller more manageable pieces:

### creating the Array Class

```java
public class Array {

    public Array(int length) { // take the length
        int[] items = new int[length]; // initialize an array with given number of elements
    }
}
```

### implementing print method

```java

public class Array {
    // to make the items array accessible to all the other methods define it here as a class property
    private int[] items;

    public Array(int length) {
        // int[] numbers = new int[length]; // if you define the array like this it will be accessible only within this method!
        items = new int[length];
    }

    public void print() {
        // if items was declared in the constructor it would've been only accessible in it only
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}
```

here is another problem! when we initialize an array with specific number of elements java provides default values! in
our case Zeros
so iterating over that array with initial values we get zeros
to solve it define another class property which represents the number of array elements and iterate over the array using
that variable!

```java

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }

    }
}
```

## Implementing insert method

this method has two parts:

1. insert the new given element at the end of the array

we can't use the `length` property as the last index to add new element at the end of the `items` array the reason being
arrays have default values in java and are pre-occupied.

therefore we use the `count` property as the last index since it's tracking the number of elements in the array

```java

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // if the array is full, resize it
        // add the new item at the end
        items[count] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
```

```java

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // if the array is full, resize it
        if (count == items.length) {
            //      create a new array (twice the size)
            int[] newItems = new int[count * 2];
            //      copy all the existing items
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            //      set items to this new array
            items = newItems;

        }
        // add the new item at the end
        items[count++] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
```

## Implementing the removeAt method

when dealing with user input ALWAYS validate the input

[1,2,3,4] then want to remove 2

take index for 2 which is 1
inside a loop start iterating over the array starting from the given index till the end
from the given index+1 (the sibling element) move them one step to the left
literally over-riding the element with given index

```java
    public void removeAt(int index) {

    // validate the index
    if (index < 0 || index >= count) {
        throw new IllegalArgumentException();
    }
    // move the items to the left to fill the hole

    for (int i = index; i < count; i++) {
        items[i] = items[i + 1];
    }
}
```

## Implementing indexOf method

```java
  public int indexOf(int item) {
    for (int i = 0; i < count; i++)
        if (items[i] == item)
            return i;
    return -1;

}
```

---

# Dynamic Arrays in Java

In Java, a dynamic array is an array that can resize itself automatically when elements are added or removed. This is
helpful because traditional arrays in Java have a fixed size, meaning you have to declare their size at the time of
creation, which cannot be changed later. Dynamic arrays overcome this limitation.

### Key Points About Dynamic Arrays

1. **Automatic Resizing**: Unlike regular arrays, dynamic arrays can grow or shrink as needed.
2. **Implementation in Java**: Java provides the `ArrayList` class in the `java.util` package to handle dynamic arrays.
3. **Underlying Array Mechanism**: Internally, `ArrayList` uses an array that grows when more space is needed.

### How ArrayList Works

1. **Initialization**: When an `ArrayList` is created, an internal array with an initial capacity is allocated.
2. **Adding Elements**: When you add an element, if the array’s current capacity is exceeded, the `ArrayList` creates a
   new, larger array, copies all elements from the old array to the new one, and then adds the new element.
3. **Resizing**: The `ArrayList` grows in size by a fixed growth rate (often 1.5 to 2 times its original size) each time
   it runs out of space.
4. **Access and Performance**: `ArrayList` provides constant-time access (O(1)) to elements by index and linear time (O(
   n)) for adding or removing elements at arbitrary positions.

### Basic Usage Example

Here’s how you might use `ArrayList`:

```java
import java.util.ArrayList;

public class DynamicArrayExample {
    public static void main(String[] args) {
        // Create a dynamic array
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Access an element
        System.out.println("Element at index 1: " + numbers.get(1)); // 20

        // Remove an element
        numbers.remove(1); // Removes element at index 1

        // ArrayList after removal
        System.out.println("ArrayList after removal: " + numbers);

        // Size of the ArrayList
        System.out.println("Size of ArrayList: " + numbers.size());
    }
}
```

### Pros and Cons of Dynamic Arrays

- **Pros**:
    - They provide flexibility with automatic resizing.
    - They allow easy insertion and removal of elements.

- **Cons**:
    - Resizing an array is an expensive operation as it involves copying elements.
    - Memory overhead due to internal resizing and capacity management.

In general, dynamic arrays like `ArrayList` are well-suited for cases where you anticipate frequent addition or removal
of elements but still need fast access by index.

## ArrayList vs Vector

In Java, both `ArrayList` and `Vector` are implementations of dynamic arrays, but they differ in several key ways:

### 1. **Synchronization**

- **ArrayList**: Not synchronized, meaning it is not thread-safe. If multiple threads access an `ArrayList`
  concurrently, and at least one modifies the list, you must manually synchronize it.
- **Vector**: Synchronized, meaning it is thread-safe. All operations on a `Vector` are synchronized by default, which
  can make it slower in single-threaded scenarios.

### 2. **Performance**

- **ArrayList**: Faster because it does not have the overhead of synchronization.
- **Vector**: Slower due to the synchronization overhead, which locks each operation, making it less efficient when
  thread safety is unnecessary.

### 3. **Growth Rate**

- **ArrayList**: Grows by about 50% of its current size when it runs out of space.
- **Vector**: Grows by 100% (doubling in size) each time it needs more capacity, although this behavior can be
  customized by specifying an increment value.

### 4. **Legacy Status**

- **ArrayList**: Part of the Java Collections Framework introduced in Java 1.2. It’s generally preferred for
  single-threaded applications.
- **Vector**: An older class that predates Java 1.2 and was part of the original Java 1.0 release. It’s now considered
  somewhat outdated, though it is still supported for backward compatibility.

### 5. **Usage Recommendation**

- **ArrayList**: Recommended for use in most cases, especially in single-threaded applications.
- **Vector**: Used mainly in legacy code or in cases where you specifically need synchronized dynamic arrays.

### Code Comparison Example

Here’s a side-by-side example of how you might use both:

```java
import java.util.ArrayList;
import java.util.Vector;

public class ListComparison {
    public static void main(String[] args) {
        // Using ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        System.out.println("ArrayList: " + arrayList);

        // Using Vector
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        System.out.println("Vector: " + vector);
    }
}
```

### Summary Table

| Feature            | ArrayList        | Vector                |
|--------------------|------------------|-----------------------|
| Synchronization    | Not synchronized | Synchronized          |
| Performance        | Faster           | Slower                |
| Growth Rate        | 50%              | 100% (doubling)       |
| Preferred Use Case | Single-threaded  | Legacy or thread-safe |

In general, `ArrayList` is preferred unless you specifically need thread safety, in which case you might use `Vector`
or, more often in modern Java, `Collections.synchronizedList(new ArrayList<>())` for a thread-safe `ArrayList`.