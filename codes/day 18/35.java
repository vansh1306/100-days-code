class Solution {
    public int calPoints(String[] ops) {
        // Create a deque to use as a stack to keep track of the points.
        Deque<Integer> stack = new ArrayDeque<>();
      
        // Loop through the operations.
        for (String op : ops) {
            switch (op) {
                case "+": // If the operation is "+", add the sum of the last two scores.
                    int last = stack.pop(); // Remove the last score from the stack.
                    int newTop = stack.peek(); // Peek at the new top without removing it.
                    stack.push(last); // Push the last score back onto the stack.
                    stack.push(last + newTop); // Push the sum of last two scores onto the stack.
                    break;
                case "D": // If the operation is "D", double the last score.
                    stack.push(stack.peek() * 2); // Peek the last score, double it, and push onto the stack.
                    break;
                case "C": // If the operation is "C", remove the last score.
                    stack.pop(); // Remove the last score from the stack.
                    break;
                default: // For any number, parse it and put onto the stack.
                    stack.push(Integer.parseInt(op)); // Parse the string to an integer and push it onto the stack.
                    break;
            }
        }
      
        // Sum up and return the points in the stack.
        int sum = 0;
        for (int score : stack) {
            sum += score; // Accumulate the scores.
        }
      
        return sum; // Return the final sum of the scores.
    }
}