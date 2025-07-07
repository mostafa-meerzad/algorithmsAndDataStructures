# Queues

Queues are **linear data structures** that follow the **First In, First Out (FIFO)** principle — the element that is
added first is the one to be removed first.

Think of a queue like a **line at a bank** or a **printer queue**. The first person to enter the line is the first to be
served.

---

## 📌 Queue in Data Structures and Algorithms (DSA)

---

### 🔹 1. **Queue Basics**

* **FIFO**: First element added is the first one to be removed.
* Elements are **added** at the **rear (or tail)** and **removed** from the **front (or head)**.

```
Example Queue: [10, 20, 30, 40]
                 ↑         ↑
               Front      Rear
```

---

### 🔹 2. **Queue Operations**

| Operation   | Description                                   |
|-------------|-----------------------------------------------|
| `enqueue()` | Add an element to the rear of the queue       |
| `dequeue()` | Remove an element from the front of the queue |
| `peek()`    | View the front element without removing it    |
| `isEmpty()` | Check if the queue is empty                   |
| `size()`    | Get the number of elements in the queue       |

---

### 🔹 3. **Queue Implementation Types**

There are several ways to implement a queue in Java:

1. **Using an array**
2. **Using a linked list**
3. **Using Java's built-in Queue interface (with LinkedList or ArrayDeque)**

---

## Notes on Java Queue

In Java, the Queue interface is part of the Java Collections Framework and represents a collection designed for holding
elements prior to processing. It adheres to the First-In,

First-Out (FIFO) principle, meaning elements are added to
the "rear" of the queue and removed from the "front."

### Key Characteristics:

- FIFO Ordering: Elements are retrieved in the same order they were inserted.
- Interface: Queue is an interface, and various concrete implementations are available, such as LinkedList (which also
  implements Deque), PriorityQueue, and implementations within the java.util.concurrent package like ArrayBlockingQueue
  and LinkedBlockingQueue.
-

### Core Methods:

- The Queue interface defines several methods for interacting with the queue:
  Adding Elements:
- add(E e): Inserts the specified element into the queue. Throws an IllegalStateException if the queue is full.
- offer(E e): Inserts the specified element into the queue. Returns true on success, false if the queue is full.
- Removing Elements:
- remove(): Retrieves and removes the head of the queue. Throws a NoSuchElementException if the queue is empty.
- poll(): Retrieves and removes the head of the queue. Returns null if the queue is empty.
  Inspecting Elements (without removal):
- element(): Retrieves, but does not remove, the head of the queue. Throws a NoSuchElementException if the queue is
  empty.
- peek(): Retrieves, but does not remove, the head of the queue. Returns null if the queue is empty.

### Code Example

```java
import java.util.LinkedList;
import java.util.Queue;

public class JavaQueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        System.out.println("Queue after adding elements: " + queue); // Output: [Apple, Banana, Cherry]

        // Peeking at the head
        String head = queue.peek();
        System.out.println("Head of the queue: " + head); // Output: Apple

        // Removing elements
        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement); // Output: Apple
        System.out.println("Queue after removing an element: " + queue); // Output: [Banana, Cherry]

        // Checking if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
    }
}
```

## Reverse a Queue

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Remove from queue and push into stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Pop from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Fill queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

```

### AS a Method

```java
package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue after adding elements: " + queue);
//        queue.remove();
//        System.out.println("Queue after removing an element: " + queue);
//        System.out.println(queue.peek());
//        queue.poll();
//        queue.poll();
//        queue.remove();
//        System.out.println("Queue after removing an element: " + queue);

        reverse(queue);
        System.out.println("Reversed queue: " + queue);


    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.add(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

    }

}
```