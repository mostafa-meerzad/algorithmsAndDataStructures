package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // these first and last variables hold head and tail of the linkedList
    private Node first = null;
    private Node last;
    private int size;

    // addFirst
    public void addLast(int item) {
        //todo
        // 1. crate a new node
        // 2. check if the list has any elements
        // if not, this new node is the first as well is the last
        // otherwise, make the last element's next, point to the new node and assign the last to tis new node
        // 3. make the last element point to the newly crated element

        // 1
        var node = new Node(item);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // addLast
    public void addFirst(int item) {
        //todo
        // create new node
        // * allocate memory for a new node and assign give value
        // handle empty list case
        // * check if first or last is null list is empty
        // * if so make the new node first and last
        // handle non-empty list case
        // * assign new node's next to the last
        // * assign the new node as the new last

        var node = new Node(item);

        if (isEmpty()) {
            // first = node;
            // last = node;
            // or
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;

    }

    // removeFirst
    public void removeFirst() {
        //todo
        // check if the list empty
        // if so
        // throw an error
        // if list has only one element
        // * empty out first and second then return
        // otherwise
        // * initialize a pointer "second" to hold the second node "first.next"
        // * update first.next to "null" so it doesn't reference any node and can be garbage-collected
        // * override first to second

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
        size--;

    }

    // deleteLast
    public void removeLast() {

        //todo
        // check if the list is empty
        // * throw an error
        // check if list has only one element
        // * update first and last to "null"
        // else
        // * traverse the list using a while loop
        // * check if current element's next is last
        // if so
        // * update last to current item
        // otherwise
        // * update current to current.next

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
//        var current = first;
//        while (current != null) {
//            if (current.next == last) {
//                last = current;
//                current.next = null;
//                return;
//            }
//            current = current.next;
//        }

        var previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;

    }

    // contains
    public boolean contains(int item) {
        //todo
        // start traversal at the first node
        // * initialize a pointer "current" to start from first node
        // traverse the list
        // * while the "current" node is not null, compare the current node's value with the target value
        // if a match is found return "True"
        // move to the next node
        // * advance the "current" pointer to the next node
        // handle the case where no match is found
        // return "False"

        Node current = first;

        while (current != null) {
            if (current.value == item) {
                return true;
            }
            current = current.next;
        }
        return false;

        // to break my mind, here is Mosh's solution
//        return indexOf(item) != -1;
    }

    // indexOf
    public int indexOf(int item) {
        //todo
        // start traversal at the first node
        // * initialize a pointer "current" to start at the first node
        // * keep track of current index using an integer variable "index"
        // travers the list
        // * while the current node is not null, compare the value of current node with the target value
        // * if a match is found return the current index
        // move to the next node
        // * advance the "current" pointer to the next node
        // * increment the index counter
        // handle the case where the value is not found
        // * if the traversal reaches the end of the list (current == null) and not match is found return -1
        int index = 0;
        Node current = first;

        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // size
    // the following implementation will work but it's time complexity is O(n), it is not very efficient, you need to traverse the array
    // everytime it's called
//    public int size() {
//        //todo
//        // define a size variable
//        // check if list is empty
//        // * if so return size is 0
//        // check if list has only one element
//        // if so size is 1
//        // otherwise
//        // * traverse the list while keep counting
//        int size;
//        if (first == null)
//            size = 0;
//        else if (first == last)
//            size = 1;
//        else {
//            Node current = first;
//            size = 1;
//            while (current.next != null) {
//                size += 1;
//                current = current.next;
//            }
//
//        }
//        return size;
//
//    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        //todo
        // define an empty array (array = [size]) with the same size as our likedList
        // declare an index variable (index = 0), to track our element's indices
        // traverse the list to the end (current.next == null)
        // in each iteration increase the index (index++) and change current to (current = current.next)

        int[] array = new int[size];
        int index = 0;
        var current = first;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;

        }
        return array;
    }


    // reverse the list
    public void reverse() {
        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }

    // to improve readability and write clean code
    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
