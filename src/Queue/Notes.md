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

## ✅ Let's Build a Queue Step by Step (Using Array)

---

### Step 1: Define Class and Fields

```java
public class MyQueue {
    private int[] data;
    private int front;  // points to the front element
    private int rear;   // points to the next insertion position
    private int size;   // number of elements
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }
}
```

---

### Step 2: Enqueue Operation

```java
public void enqueue(int value) {
    if (size == capacity) {
        System.out.println("Queue is full!");
        return;
    }
    data[rear] = value;
    rear = (rear + 1) % capacity;  // circular increment
    size++;
}
```

---

### Step 3: Dequeue Operation

```java
public int dequeue() {
    if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1; // or throw exception
    }
    int removed = data[front];
    front = (front + 1) % capacity; // circular increment
    size--;
    return removed;
}
```

---

### Step 4: Peek Operation

```java
public int peek() {
    if (isEmpty()) {
        System.out.println("Queue is empty!");
        return -1;
    }
    return data[front];
}
```

---

### Step 5: Utility Methods

```java
public boolean isEmpty() {
    return size == 0;
}

public int size() {
    return size;
}
```

---

### 🔹 Full Working Example

```java
public class MyQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int removed = data[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }
}
```

---

### 🔹 Sample Usage:

```java
public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue(); // Queue: 10 20 30

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        queue.printQueue(); // Queue: 20 30

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue is full!
        queue.printQueue(); // Queue: 20 30 40 50

        System.out.println("Front: " + queue.peek()); // 20
    }
}
```

---

## 🧠 Visual Example

Let’s say you add:
`enqueue(10)` → \[10]
`enqueue(20)` → \[10, 20]
`enqueue(30)` → \[10, 20, 30]
`dequeue()` → removes `10`, becomes \[20, 30]

---

## 📝 Summary

* Queue follows FIFO.
* Implemented using array, linked list, or Java's built-in tools.
* Use a circular array to reuse space when elements are dequeued.
* Operations: `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`.

---

