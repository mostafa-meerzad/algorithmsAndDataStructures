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
