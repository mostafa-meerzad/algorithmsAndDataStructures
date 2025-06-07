//package LinkedListReview;
//
//public class LinkedListClean {
//    // define the Node class inside the LinkedList class. because tt is purely used in this class,
//    // we need to make it private so it can't be accessed from the outside.
//    // and since it's declared inside LinkedList we have access to its private properties plus no need for getters and setters
//    private class Node {
//        private int value;
//        private Node next;
//
//        // just need a constructor to initialize the value of the node, we can't have a node that doesn't have a value
//        public Node(int value) {
//            this.value = value;
//        }
//    }
//
//    private Node first;
//    private Node last;
//
//    public void addLast(int value) {
//        var newNode = new Node(value);
//        if (first == null) {
//            first = last = newNode;
//        } else {
//            last.next = newNode;
//            last = newNode;
//        }
//
//    }
//
//    public void addLast(int value) {
//        var newNode = new Node(value);
//        if (first == null) {
//            first = last = newNode;
//        } else {
//            last.next = newNode;
//            last = newNode;
//        }
//
//    }
//    public void removeFirst() {
//        if (first == null) {
//            throw new IllegalStateException("List is empty");
//        } else {
//            var second = first.next;
//            first.next = null;
//            first = second;
//            if (first == null) {
//                last = null;
//            }
//        }
//    }
//
//    public void removeFirst() {
//        if (first == null) {
//            throw new IllegalStateException("List is empty");
//        } else {
//            var second = first.next;
//            first.next = null;
//            first = second;
//            if (first == null) {
//                last = null;
//            }
//        }
//    }
//
//    public boolean contains(int value) {
//        var current = first;
//        while (current != null) {
//            if (current.value == value) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//
//    }
//
//    public int indexOf(int value) {
//        int index = 0;
//        var current = first;
//        while (current != null) {
//            if (current.value == value) {
//                return index;
//            }
//            current = current.next;
//            index++;
//        }
//        return -1;
//    }
//}
