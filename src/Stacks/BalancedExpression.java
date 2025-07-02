package Stacks;

import java.util.Stack;

public class BalancedExpression {
    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) return false;

                char open = stack.pop();
                if (!matches(open, c)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
