package LinkedListReview;

/*
====================================
     Linked List Implementation
====================================

PROBLEM:
Create a Linked List from scratch that supports basic operations.

REQUIREMENTS:
1. Track the head of the linked-list
2. Track the end of the linked-list
3. Add an element at the beginning of the linked-list
4. Add an element at the end of the linked-list
5. Remove an element from the beginning of the linked-list
6. Remove an element from the end of the linked-list
7. Check if the provided value is in the linked-list
8. Return the index of provided value if exists, otherwise -1

DESIGN:
- Have a Class for the Node object
- Have a Class for the LinkedList with no initial value
- Track start "first" and end "last" of the list

IMPLEMENTATION Plan:
> Node itself is an Object:
    - Constructor: takes initial value for Node's value.
    - getNext: return Node's "next".
    - setNext: takes a Node object and sets current "next" to the Node's "next".
    - getValue: return Node's "value".
    - setValue: take an Integer and sets current Node's "value" to new "value"

> LinkedList:
    -Define "first" and "last" variables of type "Node" to track the start and end of the list.

> addFirst:
- Create a new Node with given value.
- if first == null:
    - Set newNode to first
- else
    - Set newNode.next to the current first.
- Set first to newNode.
- if last == null:
    - also set last to newNode.

> addLast:
- create new Node with the value.
- if the first is empty (first == null):
    - set first and last to newNode
- else:
    - Set last.next to newNode
    - Set last to newNode

> removeFirst:
- if first == null:
    - throw an error
- else:
    - get the second Node (i.g. second = first.next)
    - set first.next to null (to remove the first Node and get garbage collected)
    - set first to second
    - if first == null:
        - set last to null

> contains:
- start from the first node (current = first)
- traverse the list until current != null:
    - if current.value == value:
        return true
- return false

> indexOf:
- maintain an index starting from 0
- start from the first node (current = first)
- traverse the list until current != null:
- if current.value == value:
    - return index
- else
    - increase the index by 1 in each iteration
- return -1

> removeLast:
- if first == null:
    - throw an error
- if first == last:
    - set first and last to null
- otherwise
    - start from first
    - traverse the list until current.next == last:
    - set current.next to null
    - set last to current

> size:
- have a pointer, size = 0
- traverse the list
- increment the pointer
- return pointer

> getKthFromTheEnd(k):
- use two pointers technique
- define two pointers "slow" and "fast"
- move fast k times forward
    - use a for loop to move fast k steps
- traverse the list from start to end
    - move both pointers one step forward
- return slow

define two pointers take the "fast" pointer to the end and look back at the "slow" pointer
that is the node we want, but the tricky part is to find how many steps they are apart

 - our "fast" pointer reached the end good, we look at the "slow" pointer
 [10 => 20 => 30 => 40 => 50]
              *            *
but to accurately get the third element from the end we need to find how many steps they are apart
as we can see when the "fast" has reached the end now how many step are we apart to get the "third"
2 steps => 30 -> one step (getNext()) 40 -> two step (getNext()) 50
so we need to move "fast" two steps

"for (i = 0; i < k - 1; i++) fast = fast.next()"

 k = 1 => 50
 k = 2 => 40
 k = 3 => 30

then we traverse the list until the "fast" equals the "last" pointer
move both pointers one step ahead

return the "slow" pointer

*/
public class LinkedList {
    private Node first;
    private Node last;

    // addFirst
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;

        if (last == null) {
            last = newNode;
        }
    }

    // addLast
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }

    }
    // removeFirst

    public void removeFirst() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        } else {
            Node second = first.getNext();
            first.setNext(null);
            first = second;
            if (first == null) {
                last = null;
            }
        }
    }

    // removeLast

    public void removeLast() {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }
        if (first == last) {
            first = last = null;
        } else {
            var current = first;
            while (current.getNext() != last) {
                current = current.getNext();

            }
            last = current;
            last.setNext(null);
        }
    }

    // contains
    public boolean contains(int value) {
        Node current = first;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;

    }

    // indexOf

    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.getValue() == value) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public int size() {
        var size = 0;
        var current = first;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size()];
        int index = 0;
        var current = first;
        while (current != null) {
            array[index] = current.getValue();
            current = current.getNext();
            index++;
        }

        return array;
    }

    public void reverse() {
        if (first == null) return;

        var previous = first;
        var current = first.getNext();

        while (current != null) {
            var next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        last = first;
        last.setNext(null);
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (first == null) {
            throw new IllegalStateException("List is empty");
        }
        if (k < 1 || k > size()) {
            throw new IllegalArgumentException("k should be between 0 and size of the list");
        }

        var slow = first;
        var fast = first;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.getNext();
        }
        while (fast != last) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow.getValue();

    }

}
