package stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> mainStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.empty())
            minStack.push(val);
        else {
            int min = minStack.peek();
            if (val <= min) {
                min = val;
            }
            minStack.push(min);
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
