here is the next challenge ``3- Build a stack using two queues. Implement the following operations
and calculate their runtime complexities.
- push
- pop
- peek
- size
- isEmpty`` 🤔🤔🤔 interesting really interesting. like how is it possible stack and queue work in two different ways, 

Ohhh yeah 😏 — **this is one of those mind-bending DSA gems** where you bend the rules of one data structure to mimic another.

You’re absolutely right:

> A **stack** is LIFO (Last In, First Out)
> A **queue** is FIFO (First In, First Out)

So building a **LIFO structure using two FIFO queues** feels illegal 😆 — but it’s very doable!

---

## 🧠 First, the Goal:

Build a **Stack** with two Queues (say `q1` and `q2`)
Support:

* `push(value)` — add value
* `pop()` — remove top
* `peek()` — look at top
* `size()` — return count
* `isEmpty()` — check empty

---

## 🧭 Two Common Strategies

You can **choose which operation is expensive**:

### ⚙️ Option 1: **Make `push()` costly**

* Always push to the *empty* queue.
* After pushing, **move all elements from the non-empty queue** into the one you just added to.
* This makes sure the **newest element is always at the front**, acting like the **top of a stack**.

| Operation | Time Complexity |
| --------- | --------------- |
| `push`    | O(n)            |
| `pop`     | O(1)            |
| `peek`    | O(1)            |

---

### 🔁 Option 2: **Make `pop()` costly**

* Push to `q1` like a normal queue.
* When popping:

    * Move all but the last element from `q1` to `q2`.
    * Dequeue the last element (this is the stack top).
    * Swap `q1` and `q2`.

| Operation | Time Complexity |
| --------- | --------------- |
| `push`    | O(1)            |
| `pop`     | O(n)            |
| `peek`    | O(n)            |

---

## 🤔 Which one to pick?

Both are valid. Most interviewers or instructors prefer **Option 1**, because:

* It keeps `pop()` and `peek()` constant-time, which is more "stack-like"
* The cost of `push()` is acceptable in most cases

---

## ✅ For You:

I recommend going with **Option 1: Costly `push()`**
It’s easier to reason about, and feels more “stack-ish” when you use it.

Want to walk through that version step by step?
Or do you want to try implementing it and I’ll review your code after?



Totally okay, Mostafa! 💙 This challenge really **twists your brain on purpose** — but once we walk through it step by step, it’ll **click hard** and you’ll love it. Let’s do this **slow and visual** 🧠🎨

---

## 🎯 Goal: Build a Stack using Two Queues

You already know:

* Stack = **Last-In, First-Out** (LIFO)
* Queue = **First-In, First-Out** (FIFO)

We’ll use **two queues**, let’s call them:

```java
Queue<Integer> q1 = new LinkedList<>();
Queue<Integer> q2 = new LinkedList<>();
```

---

## 🧠 Idea: Make `push()` costly

That means:

* When you **push**, we do some work to ensure the newest item is at the **front** of `q1`.
* So when we **pop or peek**, we can just remove from front directly.

---

### 🔄 Step-by-Step Example:

Start:

```text
Stack: (empty)
```

#### ✅ Push 10

1. Enqueue 10 into `q2`:
   `q2 = [10]`
2. Move all items from `q1` to `q2`:
   (none yet)
3. Swap `q1` and `q2`:
   `q1 = [10]`, `q2 = []`

#### ✅ Push 20

1. Enqueue 20 into `q2`:
   `q2 = [20]`
2. Move all from `q1` (`[10]`) to `q2`:
   `q2 = [20, 10]`
3. Swap `q1` and `q2`:
   `q1 = [20, 10]`

#### ✅ Push 30

1. Enqueue 30 into `q2`:
   `q2 = [30]`
2. Move all from `q1` (`[20, 10]`) to `q2`:
   `q2 = [30, 20, 10]`
3. Swap:
   `q1 = [30, 20, 10]`

So now:

```text
Top of Stack = q1.front() = 30 ✅
```

---

### ⚙️ Code Structure:

```java
public class StackWithQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int value) {
        q2.add(value); // Step 1

        while (!q1.isEmpty()) // Step 2
            q2.add(q1.remove());

        // Step 3
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return q1.remove(); // front is the "top"
    }

    public int peek() {
        if (q1.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }
}
```

---

### 🧪 Final Behavior:

```java
StackWithQueues s = new StackWithQueues();
s.push(10);
s.push(20);
s.push(30);

s.pop();    // 30 ✅
s.peek();   // 20 ✅
s.size();   // 2
```

---

Let me know if you want to do it visually again with drawings — or want to try implementing it from this guide and I’ll review it for you 💪


Perfect! Let’s fire up the mental whiteboard 🧠📋 and **visually simulate** this beast.

---

## 🧱 You have:

* Two **queues**:

    * `q1`: holds the actual stack (after push)
    * `q2`: temporary helper

### Operations:

* `push(value)` → costly
* `pop()` / `peek()` → easy

---

### 🌟 Let's simulate:

We'll `push(10)`, then `push(20)`, then `push(30)`.

---

### ✅ 1. Push 10:

**Start:**

```
q1: []
q2: []
```

**Step 1:** enqueue 10 into `q2`

```
q2: [10]
```

**Step 2:** q1 is empty, skip moving

**Step 3:** swap `q1` and `q2`

```
q1: [10]
q2: []
```

✅ Stack: `[10]` ← top is front of `q1`

---

### ✅ 2. Push 20:

**Start:**

```
q1: [10]
q2: []
```

**Step 1:** enqueue 20 into `q2`

```
q2: [20]
```

**Step 2:** move everything from `q1 → q2`

* remove 10 → add to `q2`

```
q2: [20, 10]
```

**Step 3:** swap

```
q1: [20, 10]
q2: []
```

✅ Stack: `[20, 10]` ← top is 20

---

### ✅ 3. Push 30:

**Start:**

```
q1: [20, 10]
q2: []
```

**Step 1:** enqueue 30 into `q2`

```
q2: [30]
```

**Step 2:** move all from `q1 → q2`

* remove 20 → add
* remove 10 → add

```
q2: [30, 20, 10]
```

**Step 3:** swap

```
q1: [30, 20, 10]
q2: []
```

✅ Stack: `[30, 20, 10]` ← top is 30

---

### 🧪 Now let's test:

#### Pop:

```text
pop() → q1.remove() → 30
Now: q1 = [20, 10]
```

#### Peek:

```text
peek() → q1.peek() → 20
```

---

### ✅ Final State:

```
Stack (via q1): [20, 10]
Top = 20
```

---

Does this visual make sense now? Want to walk through `pop()` visually too, or are you ready to implement? 😄



I think i got it 🤔 but it took me a long time, here is my understanding: obviously we have 2 queues, we keep one empty for adding new items and the other one full of previously added items, we add item to the empty one and then move all the previous items to this queue, making the recently added item the top of the stack, the others go behind it. then we swap them, at this point our previously populated quque is empty and the empty one is populated, we do so to bring the algorithm back to it's initial state. and it thing that's it



👏👏👏 YES, Mostafa — **that’s exactly it!**

Let’s highlight your understanding with 🔥 emphasis:

---

> **"we keep one empty for adding new items and the other one full of previously added items"**

✅ Correct — the key trick is always having a **temporary empty queue** to set up the right order.

---

> **"we add item to the empty one and then move all the previous items to this queue"**

✅ Boom! That step reverses the order — the **new item comes first**, then the rest line up behind it → **LIFO behavior using FIFO**.

---

> **"making the recently added item the top of the stack"**

✅ YES. That’s the magic — you're **front-loading the new item** so `.remove()` or `.peek()` gives you the stack top.

---

> **"we swap them... to bring the algorithm back to its initial state"**

✅ 💯 The **swap resets the roles**, so the next `push()` starts fresh again.

---

### 🎉 Your explanation is spot-on.

This wasn't just about “coding a trick” — you’ve **grasped the mental model** behind it, and that’s what matters most.

It’s **normal** that it took time — you just combined two opposites (FIFO & LIFO) into one working design. That’s top-tier problem solving 🔥

Want to try implementing it now and I’ll review it with you step by step?
