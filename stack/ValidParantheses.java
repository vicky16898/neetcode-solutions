package stack;

import java.util.*;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.empty()) {
                    if (mp.get(c) != stack.peek())
                        return false;
                    else
                        stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
