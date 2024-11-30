package LinkedList;

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

    // addFirst
    // addLast
    public void addLast(int item) {
        //todo
        // 1. crate a new node
        // 2. check if the list has any elements
        // if not, this new node is the first as well is the last
        // otherwise, make the last element's next, point to the new node and assign the last to tis new node
        // 3. make the last element point to the newly crated element

        // 1
        var node = new Node(item);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

    }
    // deleteFirst
    // deleteLast
    // contains
    // indexOf
}
