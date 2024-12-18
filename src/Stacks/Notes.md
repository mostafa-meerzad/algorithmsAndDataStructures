Stacks are a fundamental data structure in computer science that operate on the **Last In, First Out (LIFO)** principle. This means that the last element added to the stack is the first one to be removed, similar to a stack of plates in a cafeteria.

---

## **Key Concepts**

1. **Structure**: 
   - A stack is a collection of elements with two main operations:
     - **Push**: Adds an element to the top of the stack.
     - **Pop**: Removes and returns the top element from the stack.

2. **LIFO Principle**: 
   - The most recently added element is the first to be removed, like taking the top plate from a stack.

3. **Top of the Stack**: 
   - The "top" refers to the most recently added element, which will be accessed first when performing operations.

4. **Access**:
   - Unlike arrays or linked lists, you can only access the element at the top of the stack directly. Other elements are "hidden" below the top.

---

## **Basic Operations**

1. **Push**
   - Adds an element to the top of the stack.
   - Example: 
     - Stack: [1, 2, 3]
     - Push(4)
     - New Stack: [1, 2, 3, 4]

2. **Pop**
   - Removes and returns the top element of the stack.
   - Example:
     - Stack: [1, 2, 3, 4]
     - Pop()
     - Popped Element: 4
     - New Stack: [1, 2, 3]

3. **Peek (or Top)**
   - Returns the element at the top of the stack without removing it.
   - Example:
     - Stack: [1, 2, 3, 4]
     - Peek() → 4
     - Stack remains: [1, 2, 3, 4]

4. **isEmpty**
   - Checks if the stack is empty.
   - Example:
     - Stack: []
     - isEmpty() → True

5. **Size**
   - Returns the number of elements in the stack.
   - Example:
     - Stack: [1, 2, 3]
     - Size() → 3

---

## **Implementing a Stack**

Stacks can be implemented using:
1. **Arrays**: A dynamic or fixed-size array can be used to represent a stack.
2. **Linked Lists**: A linked list can represent a stack where elements are added/removed from the head.

### **Array-Based Stack (Java Example)**
```java
class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1; // Stack is empty
    }

    // Push operation
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return size of the stack
    public int size() {
        return top + 1;
    }
}
```

---

### **Linked List-Based Stack (Java Example)**
```java
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    private Node top;

    // Constructor
    public Stack() {
        top = null;
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.value;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
```

---

## **Applications of Stacks**

1. **Expression Evaluation**:
   - Used in evaluating postfix expressions (e.g., Reverse Polish Notation).

2. **Expression Conversion**:
   - Converts infix expressions (e.g., `A + B`) to postfix (`AB+`) or prefix (`+AB`).

3. **Backtracking**:
   - E.g., Undo functionality in text editors or navigating browser history.

4. **Function Calls**:
   - The call stack in programming uses a stack to manage function calls and returns.

5. **Parsing**:
   - Used in parsing expressions, compilers, and syntax checking (e.g., matching parentheses).

6. **DFS (Depth First Search)**:
   - The stack is used to keep track of visited nodes in graph traversal.

---

## **Advantages and Limitations**

### **Advantages**
- Simple and easy to implement.
- Useful for managing temporary data.
- Memory-efficient for operations that strictly follow LIFO.

### **Limitations**
- Restricted access: Only the top element is accessible.
- Fixed size (for array-based implementations): Requires resizing when full.
- No random access: Unlike arrays, you cannot access arbitrary elements directly.

---

Would you like a practical exercise to test your understanding? 😊