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
        }
        else {
            node.next = last;
            last = node;
        }

    }

    // deleteFirst
    // deleteLast
    // contains
    // indexOf
    public int indexOf(int item){
        //todo
        // keep track of index and nodes
        // have a loop that loops until the current node is null
        // check if current node's value is the equal to the provided item
        // * if so return index
        // * if not assign next node to current node and increment the index
        // return -1 if can't find the index

        int index = 0;
        Node current = first;

        while(current != null){
            if(current.value == item){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    // to improve readability and write clean code
    private boolean isEmpty(){
        return first == null;
    }
}
