package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class DoubleStack {
    private int[] stack;
    private int count1;
    private int count2;

    public DoubleStack(int capacity) {

        stack = new int[capacity];
        count1 = -1;
        count2 = capacity;
    }

    public void push1(int item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++count1] = item;
    }

    public void push2(int item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[--count2] = item;
    }

    public int pop1() {
        if (isEmpty1()) throw new IllegalStateException("Stack is empty");
        return stack[count1--];
    }

    public int pop2() {
        if (isEmpty2()) throw new IllegalStateException("Stack is empty");
        return stack[count2++];
    }


    public boolean isFull() {
        return count1 + 1 == count2;
    }

    public boolean isEmpty1() {
        return count1 == -1;
    }

    public boolean isEmpty2() {
        return count2 == stack.length;
    }

}