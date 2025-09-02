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

Example:

We want to store a list of employees:

1. employeeNumber is given to the hash function.
2. The hash function returns the index telling the hash table where to store the value.
3. The value is stored at the index.

Note: the **hash function** is deterministic, so the same key always maps to the same index.

4. To retrieve the value, we compute the hash function again and fetch from the index.

![Screenshot (28).png](../../Screenshot%20%2828%29.png))
---

## 3️⃣ Hash Functions

A **hash function**:

* Produces the same output for the same input.
* Spreads keys evenly across the table (avoids clustering).
* Is fast to compute.

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

* `containsKey(key)` → **O(1)** (uses hashing). because when we pass a key to the `containsKey()` method, the hashmap
  will use the hash function to find the index of the key, then it would quickly find the value in the array and return
  the result.
* `containsValue(value)` → **O(n)** (linear search, no hashing for values). because when we pass a value to the
  `containsValue()` method, the hashmap will iterate through the whole array to find the value.

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

A string is given like `a green apple` (don't worry about the casing) we need to define a function that returns the
character that is listed only once.

plan:

1. have a hashMap/dictionary that stores each character as the `key` and the number of repetition as `value`
2. iterate over the given string
3. check the existence of the current character in the hashMap
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

the `Character.MIN_VALUE` is The constant `Character.MIN_VALUE` is a predefined constant in the class in Java. It
represents the smallest possible value of the `char` data type, which is effectively the **null character** (`'\u0000'`
or Unicode value 0). `Character`

## Set

Good morning! ☕ Let’s treat **Set** like that one friend who refuses duplicates in their life. In Data Structures and
Algorithms (DSA), a **Set** is a collection of *unique elements* where the **order doesn’t necessarily matter** (depends
on implementation).

---

## **1. What is a Set in DSA terms?**

* **No duplicates** – if you try to insert an existing element, it won’t be added again.
* **No guaranteed order** (unless you pick a specific implementation that maintains one).
* **Fast operations** – insertion, deletion, and lookup are usually O(1) on average with hash-based sets.

### Real-world analogy:

Think of it like a guest list — you can’t write the same guest twice. If someone is already invited, writing their name
again does nothing.

---

## **2. Types of Set in Java**

Java provides several implementations in `java.util`:

1. **HashSet** – unordered, uses hashing (fast, O(1) average).
2. **LinkedHashSet** – preserves insertion order (still O(1) average).
3. **TreeSet** – keeps elements sorted using a binary search tree (O(log n)).

---

## **3. Common Operations**

Here are the key operations you’ll use (DSA flavor):

* **add(element)** → Insert an item.
* **remove(element)** → Delete an item.
* **contains(element)** → Check if item exists.
* **size()** → Get number of unique elements.
* **isEmpty()** → Check if empty.
* **clear()** → Remove everything.
* **Iteration** → Loop through all elements.

---

## **4. Java Example (HashSet)**

```java
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();

        // Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20); // duplicate, will be ignored

        System.out.println("Set: " + numbers); // Output may be [20, 10, 30] (no order)

        // Check if element exists
        System.out.println("Contains 20? " + numbers.contains(20)); // true

        // Remove element
        numbers.remove(10);
        System.out.println("After removal: " + numbers);

        // Size
        System.out.println("Size of set: " + numbers.size());

        // Iterate through elements
        for (int num : numbers) {
            System.out.println("Value: " + num);
        }
    }
}
```

---

## **5. When to Use a Set in DSA**

* **Remove duplicates automatically** (e.g., unique usernames).
* **Fast lookups** (e.g., checking if an item is in a collection).
* **Performing set operations** (union, intersection, difference).
* **Avoiding index management** (you don’t need to worry about positions like in arrays).

---

## **6. Quick DSA Example – Finding Unique Elements**

Suppose you want to remove duplicates from an array:

```java
import java.util.HashSet;
import java.util.Set;

public class UniqueExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4};
        Set<Integer> unique = new HashSet<>();

        for (int num : arr) {
            unique.add(num); // duplicates ignored automatically
        }

        System.out.println("Unique elements: " + unique);
    }
}
```

---

## **7. Key Points to Remember**

* **HashSet → O(1)** average for add/remove/contains (unordered).
* **TreeSet → O(log n)** with sorted order.
* **LinkedHashSet → O(1)** with predictable insertion order.
* **No indexing!** You can’t access by position like in an array or list.

## exercise find the first repeated character

Great question! Your intuition about using a hashtable (in Java, typically a `HashMap<Character, Integer>`) is **exactly
right for counting frequencies**, but frequency alone doesn’t immediately give you the **first repeated character**
—because you’d only know counts after you finish iterating, which loses the "first occurrence" order.

Let’s break this down step by step and solve it *efficiently* in **one pass**:

---

## **Goal**

Given `"a green apple"`, return the **first character that appears more than once** → `'e'`.

---

## **Key Idea**

Instead of just counting frequencies, we check *as we go* whether we’ve seen a character before:

1. Use a `HashSet<Character>` to store characters we've **already seen**.
2. Iterate through the string **character by character**:

    * If the character is **not in the set**, add it.
    * If the character **is already in the set**, this is the **first repeated character** → return immediately.

This works because you're processing characters **in order**. The *first time* you hit a duplicate, that duplicate is
the first repeated character.

---

## **Code in Java**

```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String str = "a green apple";
        Character result = findFirstRepeatedChar(str);
        System.out.println(result); // Output: e
    }

    public static Character findFirstRepeatedChar(String str) {
        HashSet<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (ch == ' ') continue; // optional: skip spaces

            if (seen.contains(ch)) {
                return ch; // first repeated character
            }
            seen.add(ch);
        }
        return null; // no repeated character found
    }
}
```

---

## **Why not just use counts first?**

* If you just count occurrences in one loop and then scan again to find the first char with count > 1, it’s **two passes
  **.
* The HashSet method does it in **one pass** and stops as soon as it finds a duplicate—more efficient.

---

### Quick mental trace with `"a green apple"`:

1. `a` → not seen → add `a`
2. ` ` (space) → skip
3. `g` → add
4. `r` → add
5. `e` → add
6. `e` (again) → already in set → **return 'e'**

`Character.MIN_VALUE` in Java is a public static final field within the java.lang.Character class. It represents the
minimum value that a char primitive data type or a java.lang.Character object can hold.
This minimum value corresponds to the Unicode character \u0000, which is the null character. In decimal representation,
this value is 0. Since the char data type in Java is a 16-bit unsigned Unicode character, \u0000 is the smallest
possible value it can represent.