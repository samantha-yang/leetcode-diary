class Solution {
    public String removeStars(String s) {
        // Create a stack to keep track of chars encountered so far
        Stack<Character> stack = new Stack<>();

        // Iterate over each char in the input string
        for (char c : s.toCharArray()) {
            // If the char is a star, remove the topmost char from the stack
            if (c == '*') {
                stack.pop();
            // If char is not a star, add it to stack
            } else {
                stack.push(c);
            }
        }
        
        // Create StringBuilder to store chars in the stack
        StringBuilder sb = new StringBuilder();

        // Iterate over each char in stack and append it
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}