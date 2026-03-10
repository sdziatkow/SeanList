package circularLists;

public class CircAList<T> {

    private final int DEFAULT_CAPACITY = 20;
    private final int DEFAULT_START = DEFAULT_CAPACITY / 2;
    private final int RFACTOR = 2;
    private int capacity;
    private int size;
    private int first;
    private int last;
    private T[] items;

    public CircAList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = items.length;
        size = 0;
        first = DEFAULT_START;
        last = first + 1;
    }

//IMPLEMENTATION---------------------------------------------------------------------------------------------------------

    public void addFirst(T x) {
        items[first] = x;
        first = nextFirst();
        ++size;
    }
    public void addLast(T x) {
        items[last] = x;
        last = nextLast();
        ++size;
    }

    public T removeFirst() {
        T item = getFirst();
        items[prevFirst()] = null;
        first = prevFirst();
        return item;
    }
    public T removeLast() {
        T item = getLast();
        items[prevLast()] = null;
        last = prevLast();
        return item;
    }

    public T getFirst() { return items[prevFirst()]; }
    public T getLast() { return items[prevLast()]; }
    public int size() { return size; }

//ALIST-SPECIFIC---------------------------------------------------------------------------------------------------------

    private int nextFirst() { return (first - 1 + capacity) % capacity; }
    private int prevFirst() { return (first + 1) % capacity; }

    private int nextLast() { return (last + 1) % capacity; }
    private int prevLast() { return (last - 1 + capacity) % capacity; }

    private boolean shouldGrow() { return (size == capacity); }
}
