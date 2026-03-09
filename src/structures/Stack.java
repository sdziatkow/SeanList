package structures;

/**
 * Stack: A collection of elements in which only the first element is manipulated.
 * LAST IN, FIRST OUT.
 *
 */
public class Stack<T> {
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

    public Stack() {
        sentinel = new Node(null, null);
        size = 0;
    }

    /**
     * This method will add the given item as the first element in the stack.
     * @param x: The item to be added.
     */
    public void push(T x) {
        sentinel.next = new Node(x, sentinel.next);
        ++size;
    }

    /**
     * This method will remove the first item in the list.
     * @return: The first item in the stack.
     */
    public T pop() {
        Node first = sentinel.next;
        sentinel.next = first.next;
        --size;
        return first.item;
    }

    /** @return: The first item in the stack. */
    public T peek() {
        return sentinel.next.item;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param x: The element to be searched for.
     * @return: The distance from the top of the stack. If given element DNE, returns -1
     */
    public int search(T x) {
        int dist = 0;
        for (Node n = sentinel.next; n != null; n = n.next) {
            if (n.item.equals(x)) {
                return dist;
            }
            ++dist;
        }
        return -1;
    }

}
