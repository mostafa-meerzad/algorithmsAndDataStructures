package Review;
// todo
/*
==================================
    Dynamic Array Implementation
==================================
PROBLEM:
Create a dynamic array class that supports basic array operations.

REQUIREMENTS:
1. Accept an initial length/capacity
2. Print all elements
3. Dynamically resize the array as needed
4. Add new elements to the array
5. Remove elements from the array
6. Return the index for provided element
7. Return the max element
8. Insert given item at given index
9. Combine two arrays and return intersection of both
10. Reverse the order of element

DESIGN:
- Use an integer array ('items') to store elements.
- Use an integer counter ('count') to track current number elements.
- Resize logic: if full, double the current capacity and copy items.
- Have an initial max and compare to the rest, find new max
-
IMPLEMENTATION PLAN:
> CONSTRUCTOR:
- Accept 'length' and initialize 'items = new int[length]'
- Set 'count = 0'

> print():✅
- Loop from 0 to 'count - 1', print each element

> insert(item):✅
- If full 'count == items.length'
    - create a new array with double the size
    - copy old elements to new array
    - assign new array to 'items'
- Insert 'item' at 'items[count]'
- Increment 'count'

> removeAt(index):✅
- Check if 'index' is valid
- Shift element left to fill the gap
- Decrement count

> indexOf(item):✅
- Iterate over array items
- Check for a match
    - if found, return index of matched item
- No match found, return -1

> max():✅
- Get the first element as default max
- Iterate over all elements of the array comparing to default max
- Found new max, update old max
- return max

> reverse():✅
- Define a new empty array,
- Iterate over original array
- it's important to start iteration from 0
- get last element and assign it to the first element in the new array
- loop variable starting from 0 to count of elements
    - reversedInex => elements-count - loop-var - 1
    -    2         =>      3         -     0    - 1
    -    1         =>      3         -     1    - 1
    -    0         =>      3         -     2    - 1

> intersect(array):✅
- get a numbers array as argument
- find common elements between two arrays
- return array of common elements

> insertAt(index, item):
- check if index is valid
- if full, resize array
- shift elements right to make a gap for new item
- insert item at given index

> EDGE CASES:
- Insert beyond capacity --> needs resize ✅
- Remove from empty array --> return error ✅
- Invalid index for removal --> throw exception✅
*/

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public Array intersect(Array another) {
//        int [] commons = new int[Math.min(count, another.count)];
//        int commonsIndex = 0;// define a separate variable to track the index of the "commons" array
        // --------------------- better implementation ------------
        Array commons = new Array(Math.min(count, another.count));

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < another.count; j++) {
                if (items[i] == another.items[j]) {
//                    commons[commonsIndex++] = items[i];
                    commons.insert(items[i]);
                    break;
                }
            }
        }
        return commons;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;

    }

    public void reverse() {
        int[] reversedItems = new int[count];
        for (int i = 0; i < count; i++) {
            reversedItems[i] = items[count - i - 1];
        }
        items = reversedItems;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid index");
        }
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public void insert(int item) {

        if (items.length == count) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
