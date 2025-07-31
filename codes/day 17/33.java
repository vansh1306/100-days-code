class MyQueue {
    // Use two stacks to simulate a queue:
    // stkInput is used for input operations (push)
    // stkOutput is used for output operations (pop and peek)
    private Deque<Integer> stkInput = new ArrayDeque<>();
    private Deque<Integer> stkOutput = new ArrayDeque<>();

    // Constructor for MyQueue. No initialization needed as 
    // member variables are already initialized.
    public MyQueue() {
    }

    // Push element x to the back of the queue. Since a stack is LIFO (last-in, first-out),
    // pushing to stkInput will reverse the order when transferred to stkOutput.
    public void push(int x) {
        stkInput.push(x);
    }

    // Pop the element from the front of the queue.
    // If stkOutput is empty, refill it by popping all elements
    // from stkInput and pushing them into stkOutput.
    public int pop() {
        move();
        return stkOutput.pop();
    }

    // Get the front element.
    // Similar to pop, ensure stkOutput contains elements by moving
    // them from stkInput if necessary and then return the top element.
    public int peek() {
        move();
        return stkOutput.peek();
    }

    // Return true if the queue is empty, which is when both stacks are empty.
    public boolean empty() {
        return stkInput.isEmpty() && stkOutput.isEmpty();
    }

    // Helper method to move elements from stkInput to stkOutput. It ensures that
    // stkOutput contains elements in correct queue order for peeking or popping.
    private void move() {
        // Only move elements if stkOutput is empty.
        if (stkOutput.isEmpty()) {
            // Move all elements from stkInput to stkOutput.
            while (!stkInput.isEmpty()) {
                stkOutput.push(stkInput.pop());
            }
        }
    }
}