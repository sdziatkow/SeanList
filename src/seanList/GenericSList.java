package seanList;

public class GenericSList<Item> implements SeanList<Item> {

    private class Node {
        public Item item;
        public Node next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private final Node sentinel;
    private int size;

    public GenericSList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public GenericSList(Item i) {
        sentinel = new Node(null, new Node(i, null));
        size = 1;
    }

//IMPLEMENTATION---------------------------------------------------------------------------------------------------------

    /**
     * @return A Node object where its next field equals null.
     * <br>
     * If the returned Node object's item field is null as well, the list is empty.
     */
    private Node getLastNode() {
        Node last;
        for (last = sentinel; last.next != null; last = last.next);
        return last;
    }

    /**
     * @param i The index of the Node. Must be between 0 and size - 1.
     * @return The Node object at the given index i.
     */
    private Node getNode(int i) {
        if (i >= size) {
            throw new IllegalArgumentException("Given index is out of bounds size " + size);
        }
        Node x = sentinel.next;
        for (int n = 0; n < i; ++n) {
            x = x.next;
        }
        return x;
    }

    @Override
    public void addFirst(Item x) {
        sentinel.next = new Node(x, sentinel.next);
        ++size;
    }

    @Override
    public void addLast(Item x) {
        getLastNode().next = new Node(x, null);
        ++size;
    }

    @Override
    public Item getFirst() {
        return sentinel.next.item;
    }

    @Override
    public Item getLast() {
        return getLastNode().item;
    }

    @Override
    public Item get(int i) {
        return getNode(i).item;
    }

    @Override
    public Item removeLast() {
        Node last = getNode(size - 2);
        Item lastItem = last.next.item;
        last.next = null;
        --size;
        return lastItem;
    }

    @Override
    public void insert(Item x, int pos) {
        Node insert = getNode(pos - 1);
        insert.next = new Node(x, insert.next);
        ++size;
    }

    @Override
    public void replace(Item x, int pos) {
        getNode(pos).item = x;
    }

    @Override
    public int size() {
        return size;
    }

//    /** */
//    @Override
//    public void print() {
//        System.out.print("|SList [size : " + size + "]| ");
//        for (Node n = sentinel.next; n != null; n = n.next) {
//            System.out.print(n.item.toString() + " | ");
//        }
//        System.out.println();
//    }
}
