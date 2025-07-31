class Solution {
    // Method to determine if an input string has valid parentheses
    public boolean isValid(String s) {
        // Use a deque as a stack to keep track of the opening brackets
        Deque<Character> stack = new ArrayDeque<>();
        // Iterate over each character in the input string
        for (char c : s.toCharArray()) {
            // If the current character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the stack is empty or the current closing bracket doesn't match
                // the last opening bracket, the string is not valid
                if (stack.isEmpty() || !match(stack.pop(), c)) {
                    return false;
                }
            }
        }
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    // Helper method to determine if two brackets are a matching pair
    private boolean match(char leftBracket, char rightBracket) {
        // Return true if pairs match, false otherwise
        return (leftBracket == '(' && rightBracket == ')') ||
               (leftBracket == '{' && rightBracket == '}') ||
               (leftBracket == '[' && rightBracket == ']');
    }
}
