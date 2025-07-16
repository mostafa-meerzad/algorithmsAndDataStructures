# Priority Queue

A **Priority Queue** is a special type of queue in which each element is associated with a **priority**, and elements
are **served based on their priority** — not just their order of insertion (like in a normal queue).

---

## 🧠 Concept

* In a regular **Queue**, elements are processed in **First-In-First-Out (FIFO)** order.
* In a **Priority Queue**, elements with **higher priority** are processed **before** elements with **lower priority**.
* If two elements have the **same priority**, they are served according to their insertion order (depending on the
  implementation).

---

## 🔧 How It Works in Java

In Java, the `PriorityQueue` class is part of the `java.util` package. It is implemented using a **binary heap**, which
means:

* It offers **logarithmic time** for insertion and removal.
* The **head of the queue** is always the element with the **highest priority** (in Java, by default, the **lowest value
  ** is the highest priority).

---

## ✨ Basic Syntax

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Output: 10, 20, 30
        }
    }
}
```

### 🟨 Notes:

* `add()` or `offer()` is used to insert elements.
* `poll()` removes and returns the head (highest priority).
* `peek()` returns the head without removing it.

---

## 🔁 Custom Priorities (Max-Heap)

By default, Java’s `PriorityQueue` is a **min-heap** (lowest value = highest priority).
To change the priority logic, you can use a **custom comparator**.

### 🛠 Example: Max-Heap

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(30);
        pq.add(10);
        pq.add(20);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Output: 30, 20, 10
        }
    }
}
```

---

## 🧰 Real-Life Use Cases

* **Task scheduling** (urgent tasks first)
* **Dijkstra’s algorithm** (shortest path)
* **A\* pathfinding**
* **Huffman coding**

---

## 📦 PriorityQueue with Custom Objects

You can also use custom classes:

```java
class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

// Comparator: lower `priority` value means higher importance
Comparator<Task> comparator = (a, b) -> Integer.compare(a.priority, b.priority);
PriorityQueue<Task> taskQueue = new PriorityQueue<>(comparator);

taskQueue.

add(new Task("Fix bug", 1));
        taskQueue.

add(new Task("Write report", 3));
        taskQueue.

add(new Task("Email client", 2));
```

---

## Implementing a Priority Queue

Haha 😄 no worries Mostafa — it happens! You're doing great. So the challenge is to **implement a priority queue using an
array**, not stacks. Perfect! Let's break this one down too 👇

---

### 🧠 What is a Priority Queue?

A **priority queue** is a special queue where:

* Each element has a *priority*.
* The element with the **highest (or lowest)** priority is always removed first (not necessarily the one added first
  like a regular queue).

There are two main ways to implement this with arrays:

---

## ✅ Option 1: **Sorted Insertion (Efficient dequeue)**

* Keep the array **sorted** when inserting.
* This makes `enqueue` slow (because you have to insert in order), but `dequeue` is fast (just remove from start or
  end).

### 🧪 Code: Min-Priority Queue using Sorted Insert

```java
class PriorityQueue {
    private int[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Insert in sorted order (ascending: smaller = higher priority)
    public void enqueue(int value) {
        if (size == data.length) {
            throw new RuntimeException("Queue is full");
        }

        int i = size - 1;

        // Shift larger elements to the right
        while (i >= 0 && data[i] > value) {
            data[i + 1] = data[i];
            i--;
        }

        data[i + 1] = value;
        size++;
    }

    // Remove the highest priority (smallest value)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[--size]; // remove from end (highest priority at the end)
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[size - 1]; // highest priority
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

---

### 📦 Example

```java
public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.enqueue(5);
        pq.enqueue(1);
        pq.enqueue(3);

        System.out.println(pq.dequeue()); // 1
        System.out.println(pq.dequeue()); // 3
        System.out.println(pq.dequeue()); // 5
    }
}
```

---

## ⏱️ Time Complexity

| Operation | Time |
|-----------|------|
| enqueue   | O(n) |
| dequeue   | O(1) |
| peek      | O(1) |

---

### ✅ Option 2: **Unsorted Insert (Efficient insert, slow dequeue)**

If you want to do fast `enqueue` and slow `dequeue`, we can insert elements at the end and search for the min manually
on `dequeue`.

Let me know if you want to build that version too!

---

Would you also like to support:

* 🧑‍🎓 Custom object priorities (like tasks with `name` and `priority`)?
* 🔁 A circular array-based version?
* ⛰️ Or convert this to a **heap** later (for optimal performance)?

Let’s continue however you want — this is great DSA practice!

## More explanations

Absolutely, Mostafa! Let’s deeply break down this part of the code, line by line, and explain what’s happening and **why
** — especially how it maintains **sorted order** during `enqueue`.

---

### 🔁 `enqueue(int value)` - The Heart of a Sorted Insertion

```java
public void enqueue(int value) {
    if (size == data.length) {
        throw new RuntimeException("Queue is full");
    }
```

#### ✅ What's Happening:

* We're inserting a new value into the priority queue.
* The first check makes sure we don’t go beyond the array's capacity.
* `data.length` is the array's total space.
* `size` keeps track of how many elements we’ve already inserted.

If the array is full, we throw an exception.

---

```java
    int i = size - 1;
```

#### ✅ What's Happening:

* We’re starting at the **last element** in the current queue (`size - 1`).
* Our goal is to **find the correct position** to insert the new value so that the array remains sorted in ascending
  order (smallest to largest).
* We'll compare the new value to the existing values **from right to left**.

---

```java
    while(i >=0&&data[i]>value){
data[i +1]=data[i];
i--;
        }
```

#### 🔍 This is the *key* step!

Imagine inserting `3` into `[1, 2, 5, 6]`

#### ✅ What's Happening:

* We're shifting all elements **greater than `value`** one position to the right to make room for the new value.
* This is similar to how insertion sort works.
* The loop continues **as long as**:

    1. `i` is a valid index (≥ 0),
    2. `data[i] > value` → which means that element has **lower priority** than `value` (if we're treating smaller
       numbers as higher priority).

##### 💡 Example Step-by-Step (inserting `3`):

Let’s say `data[] = [1, 2, 5, 6]`, `size = 4`, and we call `enqueue(3)`:

* Start with `i = 3` (points to `6`)
* `6 > 3`, so shift `6` to index `4`
* `i = 2` → `5 > 3` → shift `5` to index `3`
* `i = 1` → `2 < 3` → stop

Now we’ve made a gap at index `2`, where we can safely insert `3`.

Intermediate state during shifting:

```
Before insert: [1, 2, 5, 6]
After shift 1: [1, 2, 5, 6, 6]
After shift 2: [1, 2, 5, 5, 6]
Insert point -> [1, 2, _, 5, 6]
```

---

```java
    data[i +1]=value;
```

#### ✅ What's Happening:

* We insert the value **at the correct position** (after all larger values have been shifted).
* Remember, `i` stopped at the last value *less than or equal to* `value`.
* So `i + 1` is the correct place to insert.

In our example:

* `i = 1` (value `2`)
* Insert `3` at `i + 1 = 2`

Final array:

```
[1, 2, 3, 5, 6]
```

---

```java
    size++;
        }
```

#### ✅ What's Happening:

* Increase the count of elements in the queue.
* `size` tracks how much of the array is used.

---

### 🧠 Why This Works:

* This ensures that the `data` array is **always sorted in ascending order**.
* Which means:

    * The **lowest number (highest priority)** is at the end.
    * So `dequeue()` can just pop `data[size - 1]` with no searching.

---

### 📌 Visualization Summary

If array is:
`[1, 2, 5, 6]` and you insert `3`:

1. Start from right: Compare `6 > 3`, shift `6`
2. Compare `5 > 3`, shift `5`
3. Compare `2 < 3`, stop
4. Insert `3` in the gap

Final: `[1, 2, 3, 5, 6]`

---

Let me know if you want me to visualize this in a diagram or trace another example like inserting `0`, `10`, or handle
edge cases like inserting into an empty queue!
