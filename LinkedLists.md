# Linked Lists

### **Linked List Overview**

A **linked list** is a data structure consisting of a sequence of elements (called nodes), where each node contains:

1. **Data**: The actual value or information the node holds.
2. **Next**: A reference (or pointer) to the next node in the sequence.

Unlike arrays, linked lists:

- Do not store elements in contiguous memory locations.
- Can dynamically grow or shrink in size.
- Are better suited for scenarios involving frequent insertions and deletions.

### **Types of Linked Lists**

1. **Singly Linked List**: Each node has one pointer, which points to the next node.
2. **Doubly Linked List**: Each node has two pointers, one pointing to the next node and the other to the previous node.
3. **Circular Linked List**: The last node points back to the first node, forming a loop.

---

### **Key Operations on Linked Lists**

1. **Insertion**:
   - At the beginning.
   - At the end.
   - At a specific position.
2. **Deletion**:
   - From the beginning.
   - From the end.
   - From a specific position.
3. **Traversal**: Visiting each node to access or process its data.
4. **Searching**: Finding a specific node based on its data.

---

### **Advantages of Linked Lists**

1. Dynamic size: Unlike arrays, no need to predefine the size.
2. Efficient insertions/deletions: Especially for large datasets.
3. No memory wastage: Allocates memory as needed.

### **Disadvantages of Linked Lists**

1. Slower access: O(n) time complexity for accessing elements, compared to O(1) for arrays.
2. Extra memory usage: Storing pointers consumes additional memory.

The time complexity of operations on a linked list depends on the specific operation and the type of linked list (singly, doubly, or circular). Here's a breakdown:

---

### **1. Traversal**

- **Time Complexity**: \(O(n)\)
- **Reason**: To access a specific node, you must start at the head and follow the links sequentially until the desired node is reached. There is no direct indexing like arrays.

---

### **2. Insertion**

#### **At the Beginning**

- **Time Complexity**: \(O(1)\)
- **Reason**: No traversal is needed. You create a new node, update its `next` pointer to the current head, and set the head to this new node.

#### **At the End**

- **Time Complexity**:
  - \(O(n)\) for **singly linked list** (if no tail pointer is maintained).
  - \(O(1)\) for **doubly linked list or singly linked list with a tail pointer**.
- **Reason**:
  - In a singly linked list without a tail, you must traverse the entire list to find the last node.
  - If a tail pointer is maintained (or for doubly linked lists), the last node is readily accessible.

#### **At a Specific Position**

- **Time Complexity**: \(O(n)\)
- **Reason**: You must traverse the list to locate the desired position, which can take up to \(O(n)\) time. Inserting itself is \(O(1)\).

---

### **3. Deletion**

#### **From the Beginning**

- **Time Complexity**: \(O(1)\)
- **Reason**: The head is directly accessible. You simply update the head to the next node.

#### **From the End**

- **Time Complexity**:
  - \(O(n)\) for **singly linked list**.
  - \(O(1)\) for **doubly linked list**.
- **Reason**:
  - In a singly linked list, you must traverse the entire list to find the second last node.
  - In a doubly linked list, the previous node of the tail is directly accessible.

#### **At a Specific Position**

- **Time Complexity**: \(O(n)\)
- **Reason**: To delete a node at a specific position, you must traverse the list to find the node or its predecessor.

---

### **4. Searching**

- **Time Complexity**: \(O(n)\)
- **Reason**: You must traverse the list sequentially to find the node with the desired value. There is no random access capability.

---

### **Summary Table**

| **Operation**             | **Singly Linked List** | **Doubly Linked List** |
| ------------------------- | ---------------------- | ---------------------- |
| Insertion at Beginning    | \(O(1)\)               | \(O(1)\)               |
| Insertion at End          | \(O(n)\) / \(O(1)^\*\) | \(O(1)\)               |
| Deletion at Beginning     | \(O(1)\)               | \(O(1)\)               |
| Deletion at End           | \(O(n)\)               | \(O(1)\)               |
| Insertion at Specific Pos | \(O(n)\)               | \(O(n)\)               |
| Deletion at Specific Pos  | \(O(n)\)               | \(O(n)\)               |
| Searching                 | \(O(n)\)               | \(O(n)\)               |

- \(O(1)\) insertion at the end for singly linked lists is possible if a tail pointer is maintained.

---

### **Why These Complexities?**

The fundamental reason for the above complexities lies in the **sequential nature** of linked lists:

- Nodes are scattered in memory and connected via pointers.
- There is no direct indexing or quick access mechanism (like arrays), so most operations involve sequential traversal to find nodes.
