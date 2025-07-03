package Stacks;

import java.util.LinkedList;

public class Stack {
//    private int[] stack = new int[5];
//    private int count = 0;
//
//    public Stack() {
//    }
//
//    public void push(int item) {
//        if (count == stack.length) throw new StackOverflowError();
//        stack[count++] = item;
//    }
//
//    public int pop() {
//        if (isEmpty()) throw new IllegalStateException();
//        return stack[--count];
//    }
//
//    public int peek() {
//        if (isEmpty()) throw new IllegalStateException();
//        return stack[count - 1];
//    }
//
//    public boolean isEmpty() {
//        return count == 0;
//    }
//
//    public int size() {
//        return count;
//    }
//
//    @Override
//    public String toString() {
//        var content = Arrays.copyOfRange(stack, 0, count);
//        return Arrays.toString(content);
//    }

    //-------------------------- stack with linked-list -----------------------------------

    private LinkedList<Integer> stack = new LinkedList<>();

    public Stack() {
    }

    public void push(int item) {
        stack.add(item);
    }

    public int pop() {
        return stack.removeLast();
    }

    public int peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

}
