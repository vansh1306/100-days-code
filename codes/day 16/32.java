import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {
    private Deque<Integer> mainQueue = new ArrayDeque<>();
    private Deque<Integer> auxQueue = new ArrayDeque<>();

    // Constructor for the stack
    public MyStack() {
        // No initialization needed as Java Deque is initialized by default
    }

    // Method to push an element into the stack
    public void push(int x) {
        // Add the element to the auxiliary queue
        auxQueue.offer(x);
      
        // Move all elements from the main queue to the auxiliary queue, reversing the order
        while (!mainQueue.isEmpty()) {
            auxQueue.offer(mainQueue.poll());
        }
      
        // Swap the main and auxiliary queues
        Deque<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
    }

    // Method to pop an element from the top of the stack
    public int pop() {
        // Remove and return the front element from the main queue
        return mainQueue.poll();
    }

    // Method to get the top element of the stack
    public int top() {
        // Get the front element from the main queue without removing it
        return mainQueue.peek();
    }

    // Method to check if the stack is empty
    public boolean empty() {
        // Return true if the main queue is empty
        return mainQueue.isEmpty();
    }
}

// Class usage:
// MyStack stack = new MyStack();
// stack.push(1);
// int popped = stack.pop();
// int topElement = stack.top();
// boolean isEmpty = stack.empty();