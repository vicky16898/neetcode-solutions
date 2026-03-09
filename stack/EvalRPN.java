package stack;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int val2 = Integer.parseInt(stack.pop());
                int val1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (token.equals("+")) {
                    res = val1 + val2;
                } else if (token.equals("-")) {
                    res = val1 - val2;
                } else if (token.equals("*")) {
                    res = val1 * val2;
                } else {
                    res = val1 / val2;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
