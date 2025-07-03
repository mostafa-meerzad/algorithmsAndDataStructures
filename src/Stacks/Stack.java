package Stacks;

import java.util.Arrays;

public class Stack {
    private int[] stack = new int[5];
    private int count = 0;

    public Stack() {
    }

    public void push(int item) {
        //stack[count] = item;
        //count++;
        if (count == stack.length) throw new StackOverflowError();
        stack[count++] = item;
    }

    public int pop() {
        // return stack[count - 1]
        // count--
        if (isEmpty()) throw new IllegalStateException();
        return stack[--count];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }

}
