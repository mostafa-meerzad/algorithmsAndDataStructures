package Stacks;

import java.util.Stack;

public class Expression {
    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {

            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (c == ')' && top != '(' ||
                    c == ']' && top != '[' ||
                    c == '}' && top != '{' ||
                    c == '>' && top != '<'
                ) return false;
            }
        }
        return stack.isEmpty();
    }
}
