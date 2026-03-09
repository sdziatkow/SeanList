package structures;

public class Queue<T> {
    private class Node {
        T item;
        Node next;
        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }

    private int size;
    private Node sentinel;

    public Queue() {
        sentinel = new Node(null, null);
    }

    /** add to back of queue **/
    public void enqueue(T x) {
        Node last;
        for (last = sentinel; last.next != null; last = last.next);
        last.next = new Node(x, null);
        ++size;
    }

    /** remove from front of queue **/
    public T dequeue() {
        Node first = sentinel.next;
        sentinel.next = first.next;
        --size;
        return first.item;
    }

    public T peek() {
        return sentinel.next.item;
    }
}
