package Queue;

public class LinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(int value){
        Node newNode = new Node(value);
        if(tail == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst(){
        if(head == null){
            throw new IllegalStateException("Queue is empty");
        }
        int value = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return value;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;
    }

}
