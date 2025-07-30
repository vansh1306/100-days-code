// Java implementation of Queue
import java.util.LinkedList;
import java.util.Queue;

class MyQueue {
    private Queue<Integer> q = new LinkedList<>();

    public boolean isEmpty() { return q.isEmpty(); }

    public void enqueue(int x) { q.add(x); }

    public void dequeue() { if (!isEmpty()) q.poll(); }

    public int getFront() { return isEmpty() ? -1 : q.peek(); }

    public void display() { for (int x : q) System.out.print(x + " "); System.out.println(); }
}

public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.getFront());
        q.dequeue();
        q.enqueue(4);
        q.display();
    }
}