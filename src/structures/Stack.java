package structures;

/**
 * LIFO - LAST IN, FIRST OUT.
 * @param <T>: The type of Object to be stored.
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

    private final Node TOP;
    public Stack() {
        TOP = new Node(null, null);
    }

    /**
     * This method will add the given item as the first element in the stack.
     * @param x: The item to be added.
     */
    public void push(T x) {
        TOP.next = new Node(x, TOP.next);
    }

    /**
     * This method will remove the first item in the list.
     * @return: The first item in the stack.
     */
    public T pop() {
        Node first = TOP.next;
        TOP.next = first.next;
        return first.item;
    }

    /** @return: The first item in the stack. */
    public T peek() { return TOP.next.item; }
    public boolean isEmpty() { return TOP.next == null; }

    /**
     * @param x: The element to be searched for.
     * @return: The distance from the top of the stack. If given element DNE, returns -1
     */
    public int search(T x) {
        int dist = 0;
        for (Node n = TOP.next; n != null; n = n.next) {
            if (n.item.equals(x)) {
                return dist;
            }
            ++dist;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (Node n = TOP.next; n != null; n = n.next) {
            out.append(n.item);
            if (n.next != null) {
                out.append(", ");
            }
        }
        out.append("]");
        return out.toString();
    }

}
