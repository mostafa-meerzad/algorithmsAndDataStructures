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
- ff first == null:
    - Set newNode to first
- else
    - Set newNode.next to the current first.
- Set first to newNode.
- if last == null:
    - also set last to newNode.


*/
public class LinkedList {
    private Node first;
    private Node last;

    // addFirst
    // addLast
    // removeFirst
    // removeLast
    // contains
    // indexOf

}
