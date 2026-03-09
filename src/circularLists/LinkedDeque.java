package circularLists;

public class LinkedDeque<T> {

    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel; // The last element.
        sentinel.next = sentinel; // The first element.
        size = 0;
    }

    public void addFirst(T x) {

        // First node's previous is always sentinel, and next node is current first node.
        Node first = new Node(x, sentinel, sentinel.next); // Single link (sentinel <- newFirst -> currFirst)

        // Update current first Node's prev to new first node.
        sentinel.next.prev = first; // Double link (newFirst <- currFirst)

        // Update first node
        sentinel.next = first; // Double link (sentinel -> newFirst)
        ++size;
    }

    public void addLast(T x) {
        Node last = new Node(x, sentinel.prev, sentinel); // Single link (currLast <- newLast -> sentinel)
        sentinel.prev.next = last; // Double link (currLast -> newLast)
        sentinel.prev = last; // Double link (newLast <- sentinel)
        ++size;
    }

    public T removeFirst() {
        if (size == 0) return null;
        Node first = sentinel.next;
        sentinel.next = first.next;
        sentinel.next.prev = sentinel;
        --size;
        return first.item;
    }

    public T removeLast() {
        if (size == 0) return null;

        // 2ndLast.next == last | last.prev == 2ndLast; last.next == sentinel | sentinel.prev == last.
        Node last = sentinel.prev; // 2ndLast <-> last <-> sentinel.

        // sentinel.prev == 2ndLast BUT 2ndLast.next STILL POINTS TO LAST
        sentinel.prev = last.prev; // 2ndLast <- sentinel | 2ndLast.next -> last

        // VERY IMPORTANT - now nothing points to last | 2ndLast.next == sentinel
        sentinel.prev.next = sentinel; // 2ndLast <-> sentinel | last
        --size;
        return last.item;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        for (Node n = sentinel.next; n.item != null; n = n.next) {
            out.append(n.item);

            if (n.next.item != null) {
                out.append(", ");
            }
        }
        out.append("]");
        return out.toString();
    }
}