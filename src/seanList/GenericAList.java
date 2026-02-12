package seanList;

public class GenericAList<Item> implements SeanList<Item>{

    private Item[] items;
    private int size;
    private final int RFACTOR = 2;

    public GenericAList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

//IMPLEMENTATION---------------------------------------------------------------------------------------------------------

    @Override
    public void addFirst(Item x) {
        Item[] a = (Item[]) new Object[size + 1];
        a[0] = x;
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        ++size;
    }

    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = x;
        ++size;
    }

    @Override
    public Item getFirst() {
        return items[0];
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item get(int i) {
        validateIdx(i);
        return items[i];
    }
    
    @Override
    public Item removeLast() {
        Item last = getLast();
        items[size - 1] = null;
        size -= 1;
        return last;
    }

    @Override
    public void insert(Item x, int pos) {

        validateIdx(pos);
        // Create new array with an extra spot.
        Item[] a = (Item[]) new Object[size + 1];

        // Copy from items (0, pos] to a[]
        System.arraycopy(items, 0, a, 0, pos);
        a[pos] = x;

        // Copy from items (pos, size - pos] to a[].
        System.arraycopy(items, pos, a,  pos + 1, size - pos);
        items = a;
        ++size;
    }

    @Override
    public void replace(Item x, int pos) {
        validateIdx(pos);
        items[pos] = x;
    }

    @Override
    public int size() {
        return size;
    }

//ALLIST-SPECIFIC--------------------------------------------------------------------------------------------------------

    /** */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void shrink() {

    }

    private boolean shouldShrink() {

        return true;
    }

}
