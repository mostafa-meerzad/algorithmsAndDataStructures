# HashTables
---

# 📘 Hash Tables in Java (Beginner-Friendly Notes)

---

## 1️⃣ What is a Hash Table?

A **Hash Table** (or **Hash Map**) is a **key-value pair** data structure.
It stores values (data) and associates them with unique keys for **fast lookup, insertion, and deletion**.

✅ **Average Time Complexity:**

* Insert: **O(1)**
* Search: **O(1)**
* Delete: **O(1)**

---

### 🔑 Analogy: Dictionary

Think of a **real dictionary**:

* To find "Apple", you jump directly to the "A" section (instead of scanning every word).
* Similarly, hash tables "jump" to the data using a **hash function**.

Without hashing:

* Search in an array or linked list → **O(n)**

With hashing:

* Search in a hash table → **O(1)** (average)

---

## 2️⃣ How Does a Hash Table Work?

1. **Key → Hash Function → Index**
   A hash function converts a **key** (e.g., `"apple"`) into an **index**:

   ```
   hash("apple") → 4
   ```

2. **Store Value at Index**
   The value is stored in an **array-like structure** at that index.

```
Index:  0   1   2   3   4   5
Value:      -   -   -  "apple"
```

3. **Retrieve Value**
   To retrieve `"apple"`, compute `hash("apple") → 4` and directly fetch from index `4`.

---

## 3️⃣ Hash Functions

A **hash function**:

* Produces the same output for the same input.
* Spreads keys evenly across the table (avoids clustering).
* Is fast to compute.

Example:

```java
int index = Math.abs(key.hashCode()) % tableSize;
```

---

## 4️⃣ Collisions

A **collision** occurs when two keys hash to the same index:

```
hash("apple") → 4  
hash("grape") → 4 (collision!)
```

### 🛠 Collision Handling Methods:

1. **Separate Chaining (Linked List)**
   Each index stores a **list of key-value pairs**:

   ```
   Index 4 → [ ("apple", value), ("grape", value) ]
   ```

2. **Open Addressing**
   If an index is taken, find the next empty slot.

    * **Linear Probing**: Check next slots one by one.
    * **Quadratic Probing**: Jump ahead by squares (1², 2², 3²…).
    * **Double Hashing**: Use a second hash function to find a new slot.

---

## 5️⃣ Load Factor

The **load factor** measures how full the hash table is:

```
Load Factor = (Number of Entries) / (Size of Table)
```

When the load factor exceeds a threshold (default 0.75 in Java), the table **resizes (rehashes)**.

---

## 6️⃣ Hash Table Implementations in Java

Java provides different hash-based collections:

* **`Hashtable` (Old, synchronized):**

    * Thread-safe, but slower.
    * No `null` keys or values.

* **`HashMap` (Modern, faster):**

    * Allows one `null` key and multiple `null` values.
    * Not synchronized (faster for single-thread use).

* **`ConcurrentHashMap`:**

    * Thread-safe and faster in multi-threaded environments.

✅ Use **`HashMap`** in most cases.

---

## 7️⃣ Basic Example in Java (Using HashMap)

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
      //Map is the interface___________HasMap is the implementation 

        // Insert key-value pairs
        map.put(10, "John");
        map.put(20, "Jane");
        map.put(30, "Jill");
        System.out.println(map); // {20=Jane, 10=John, 30=Jill}

        // Retrieve a value
        System.out.println(map.get(10)); // John

        // Check if key exists
        System.out.println(map.containsKey(20)); // true

        // Remove a key
        map.remove(20);
        System.out.println(map); // {10=John, 30=Jill}
    }
}
```

---

## 8️⃣ Iterating Over HashMaps

### 🔑 Get All Keys:

```java
for(var key :map.

keySet()){
        System.out.

println(key); // Prints all keys
}
```

### 🔑 Get All Key-Value Pairs:

```java
for(var entry :map.

entrySet()){
        System.out.

println(entry);          // key=value
    System.out.

println(entry.getKey()); // key only
        System.out.

println(entry.getValue());// value only
        }
```

---

## 9️⃣ `containsKey()` vs `containsValue()`

* `containsKey(key)` → **O(1)** (uses hashing).
* `containsValue(value)` → **O(n)** (linear search, no hashing for values).

---

## 🔟 Why HashMap is **O(1) on Average**

* Keys are hashed → direct index lookup (fast).
* Collisions are rare if hashing is good.
* Worst case (**O(n)**) happens only if many collisions turn buckets into linked lists.

Other structures (arrays, trees) focus on **worst-case time** because they are deterministic, while hashing is *
*probabilistic** (average-case dominates in practice).

---

## 🔬 Real-World Use Cases

* **Caching (fast lookups)**
* **Counting frequencies** (word count, duplicates)
* **Database indexing**
* **Compilers (variable lookups)**
* **Unique data enforcement (e.g., sets)**

---

## 🔥 Course Example Recap

```java
Map<Integer, String> map = new HashMap<>();
map.

put(1,"John");
map.

put(2,"Jane");
map.

put(3,"Joe");

System.out.

println(map.containsKey(1)); // true
        System.out.

println(map.containsValue("Joe")); // true (O(n))
```

---

## ✅ Summary (Beginner's Key Points)

1. Hash tables store data as **key-value pairs**.
2. **Hashing** maps keys to indices for **O(1)** lookup.
3. Handle **collisions** using chaining or open addressing.
4. In Java, use **`HashMap`** unless you need thread safety.
5. **Average-case performance is O(1)**, worst-case is rare.

---

Would you like me to also include a **"Build Your Own HashTable in Java" implementation** (like from scratch with
`put()`, `get()`, `remove()`)?



## HashMap Exercise

### Find the First Non-Repeated Character

A string is given like `a green apple` (don't worry about the casing) we need to define a function that returns the character that is listed only once.

plan:

1. have a hashMap/dictionary that stores each character as the `key` and the number of repetition as `value`
2. iterate over the given string
3.   check the existence of the current character in the hashMap
4.      if exist: increase it's repetition count by 1
5.      else add it to the hashMap and set it's repetition count to 1
6. iterate over the hashMap and return the key that has the smallest repetition count


```java

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch : chars) {
//            if (map.containsKey(ch)){
//                var count = map.get(ch);
//                map.put(ch, count + 1);
//            }
//            else{
//                map.put(ch, 1);
//            }
// ---------------- the if/else statement above can be written as following ------------------
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);

        }
        for (var item : chars) {
            if (map.get(item) == 1) {
                return item;
            }
        }

        return Character.MIN_VALUE; 

    }
}
```

the `Character.MIN_VALUE` is The constant `Character.MIN_VALUE` is a predefined constant in the class in Java. It represents the smallest possible value of the `char` data type, which is effectively the **null character** (`'\u0000'` or Unicode value 0). `Character`
