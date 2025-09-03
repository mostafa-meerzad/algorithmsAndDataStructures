# Hash Function

```java

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
//        when we insert a key value pair, the hash table gets the key and based on that will figure out where in the memory, technically they are stored in an array.
// in other words, the hash table should map the key to an index value, the index in which the value is stored. and that is the job of the hash function. it basically takes a value and maps it to a different kind of value. which is normally called "hash value", "hash key", "hash code" or just "hash".
    }
}


```

---

## 1. What’s a hash function in DSA terms?

A **hash function** is just a function that takes some input (key) and turns it into a number (called a hash code).

* Input → anything (string, object, number)
* Output → always an integer

We use this number to figure out **which bucket or index** to store the value in an array-based structure like a **hash
table** (used in HashMaps, HashSets, etc.).

**Example (conceptual):**

```
hash("Mosh") = 613
hash("John") = 287

internally, strings are represented by number (ASCII codes)
```

But our table size might be small (say size = 10), we don't want to create 600 indexes just to store 10 items, so we map
it:

**Note**: the technique is to get the modulo of the hash code and the table size.

```
index = hash(key) % size
index = 613 % 10 → 3
index = 287 % 10 → 7
```

* `"Mosh"` stored at bucket 3
* `"John"` stored at bucket 7

---

## 2. Why do we need hash functions?

We want **fast lookups** — ideally O(1) time:

* With an array, index lookups are O(1) but require integer keys.
* With a linked list, lookups are O(n).
* **With a hash function, we can turn any key (like a string) into an index, and get near O(1) lookups.**

---

## 3. What makes a good hash function?

A good hash function should:

1. **Be fast** (simple math, no heavy work).
2. **Be consistent** — same input → same hash every time.
3. **Distribute keys evenly** — so items don’t all pile up in the same bucket.

---

## 4. Collisions are inevitable

What if two keys produce the same index?

```
hash("Mosh") % 10 = 3
hash("Hash") % 10 = 3
```

Both go to index 3 — this is called a **collision**.

We handle collisions in two common ways:

1. **Chaining** → each bucket stores a linked list of items.
2. **Open addressing** → find the next open spot in the array (linear probing, quadratic probing, etc.).

Mosh focuses on chaining in his DSA course.

---

## 5. How to design a simple hash function manually

Let’s say we’re hashing strings.

**Step 1 — convert chars to numbers:**

* Take each character’s ASCII code.
* Add or multiply them to create a combined number.

**Very simple example (not great but works):**

```java
int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray())
        hash += c; // add up ASCII codes
    return hash;
}
```

**Better example (reduces clustering):**

```java
int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray())
        hash = (hash * 31 + c); // multiply + add pattern
    return hash;
}
```

* Multiplying by 31 spreads values more evenly than just adding.

---

## 6. Mapping to a table index

If table size is `size`, map hash to index:

```java
int index = hash(key) % size;
```

This ensures the index stays within `0` to `size-1`.

---

## 7. Example: building a hash table manually

Let’s say table size = 5.

Insert `"cat"`:

```
hash("cat") = (99*31 + 97)*31 + 116 = 3078 (just an example)
index = 3078 % 5 = 3
store "cat" at bucket 3
```

Insert `"dog"`:

```
hash("dog") = ...
index = ... % 5 = 1
store "dog" at bucket 1
```

Insert `"tac"`:

```
hash("tac") = ...
index = ... % 5 = 3
bucket 3 already has "cat" → collision → use chaining
bucket[3] → ["cat" -> "tac"]
```

---

## 8. Key takeaway (DSA level)

* A hash function **converts a key to an index**.
* Must be **fast**, **consistent**, and **distribute keys evenly**.
* Collisions **must be handled** (chaining is easiest to understand).
* In real Java, `hashCode()` already exists for strings, numbers, etc. — but understanding how to write one is key for
  DSA learning.

---

Do you want me to **draw this visually** (like buckets and arrows) so it really sticks? Or should I show **how to
implement a full hash table with chaining step by step** in Java like Mosh does?

en addressing