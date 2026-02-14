package seanList;

public interface SeanList<Item> {

    /** This method will add the given Item as the first element in the list. */
    void addFirst(Item x);

    /** This method will add the given Item as the last element in the list. */
    void addLast(Item x);

    /** @return: The first Item in the list. */
    Item getFirst();

    /** @return: The last Item in the list. */
    Item getLast();

    /** @return: The Item at the given index. */
    Item get(int i);

    /** @return: The first Item in the list which is now removed. */
    Item removeFirst();

    /** @return: The last Item in the list which is now removed. */
    Item removeLast();

    /** @return: The Item at given index which is now removed. */
    Item remove(int i);

    /** Inserts given x at given pos. */
    void insert(Item x, int pos);

    /** Replaces element at given pos with given Item. */
    void replace(Item x, int pos);

    /** @returns The number of items in the list. */
    int size();

    default void validateIdx(int i) {
        if (i < 0 || i >= size()) {
            throw new IllegalArgumentException("Index " + i + " out of bounds for size: " + size());
        }
    }
    default void print() {
        System.out.print("|" + getClass().getSimpleName() + " [size : " + size() + "]| ");
        for (int i = 0; i < size(); ++i) {
            System.out.print(get(i) + " | ");
        }
        System.out.println();
    }
}
