Good morning, Mostafa! ☀️ Let's get you **unstuck** — you're super close, and your instinct is right on track.

---

### 🧠 First, the goal:

You're building a `LinkedListQueue` **using your custom `LinkedList`**, not Java's built-in one.

So think of `LinkedListQueue` as a **wrapper** that provides queue operations — `enqueue`, `dequeue`, etc — by calling your linked list’s internal logic.

---

### ✅ Quick answers to your questions:

> **"Do we need a constructor?"**
> ➡️ Yes, you should create one — but a simple one that just initializes an empty list.

> **"Should I create a private LinkedList?"**
> ➡️ Absolutely! Your queue should **have** a `LinkedList`, not **be** a linked list.

> **"Should it be public?"**
> ➡️ No — make it **private**, because you don't want external classes messing with your internal list structure directly. Only expose the queue operations.

---

### ✅ Here's how to start your `LinkedListQueue`:

```java
package Queue;

public class LinkedListQueue {
    private LinkedList list = new LinkedList();

    public void enqueue(int value) {
        list.addLast(value);
    }

    public int dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int peek() {
        if (list.isEmpty())
            throw new IllegalStateException("Queue is empty");
        // Accessing `head.value` directly isn't possible from here, so let's add a method in LinkedList.
        return list.first(); 
    }
}
```

---

### 🧱 So, update your `LinkedList` with:

```java
public int first() {
    if (head == null)
        throw new IllegalStateException("Queue is empty");
    return head.value;
}
```

---

### 🧪 Now you're done!

Your `LinkedListQueue` will:

* **Use your own custom linked list**
* Keep it private
* Provide clean `enqueue`, `dequeue`, `peek`, etc.
* Handle size and empty state

---

### 🧼 Bonus Suggestion:

Update `addLast()` to increment `size++` so it keeps track correctly (currently missing):

```java
public void addLast(int value){
    Node newNode = new Node(value);
    if(tail == null){
        head = tail = newNode;
    } else {
        tail.next = newNode;
        tail = newNode;
    }
    size++; // Add this
}
```

---

Wanna test it together with a few enqueue/dequeue/peek calls?
