package circularLists;

public class CircAList<T> {

    private final int DEFAULT_CAPACITY = 20;
    private final int DEFAULT_START = DEFAULT_CAPACITY / 2;
    private int capacity;
    private int size;
    private int first;
    private int last;
    private T[] items;

    public CircAList() {
        capacity = DEFAULT_CAPACITY;
        items = (T[]) new Object[capacity];
        size = 0;
        first = DEFAULT_START;
        last = first + 1;
    }

    private int nextFirst() { return (first - 1 + capacity) % capacity; }
    private int nextLast() { return (last + 1) % capacity; }

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

    public T remove(int idx) {
        T item = items[first + idx];
        items[first + idx] = null;
        return item;
    }
    public T removeFirst() {
        T item = items[first];
        items[first] = null;
        --size;
        return item;
    }
    public T removeLast() {
        T item = items[last];
        items[last] = null;
        --size;
        return item;
    }

    public T getFirst() { return items[first]; }
    public T getLast() { return items[last]; }
    public int size() { return size; }

}
