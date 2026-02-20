public class ValidParentheses {
    public boolean isValid(String s) {
        // Create stack to keep track of open parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If open parentheses, push to stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If there are no parentheses in stack, then it's invalid
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the top of stack and check if it matches current closing parentheses
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // If stack is empty, then all parentheses are valid
        return stack.isEmpty();
    }
}