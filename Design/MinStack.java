import java.util.*;
class MinStack {

    // Stores all pushed values
    private Stack<Integer> stack;
    // Stores the min so far at that level
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // Push value onto stack
        stack.push(val);
        // Push to min stack if this value is a new or duplicate min
        // Using <= ensures duplicate mins are tracked so pop() stays correct
        if (minStack.isEmpty() || val <= minStack.peek()) {
            // Push this value onto the min stack
            minStack.push(val);
        }
    }

    public void pop() {
        // If there are no elements on the stack, return
        if (stack.isEmpty()) {
            return;
        }
        // Pop the top most element on the stack
        int top = stack.pop();
        // If this element is the min, remove it from the min stack too
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    // Return the top most elem on the stack
    public int top() {
        return stack.peek();
    }

    // Get the top most elem on the min stack
    public int getMin() {
        return minStack.peek();
    }
}