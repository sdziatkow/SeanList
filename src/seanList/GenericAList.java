
package seanList;

/** GenericAList.java
 * FIELDS:
 *  items        - Array object used to store Item objects.
 *  size         - The total amount of items being kept track of in the array. When size == items.length, MUST resize.
 *  offset       - The index of the first item being kept track of in the array. When zero, MUST resize.
 *  RFACTOR      - The factor by which items.length is resized by.
 *  SHRINK_RATIO - The useageRatio() at which items.length should be sized down.
 *  GROW_RATIO   - The useageRatio() or offsetRatio() at which items.length should be sized up.
 */
public class GenericAList<Item> implements SeanList<Item> {
    private Item[] items;
    private int size;
    private int offset;
    private final int DEFAULT_SIZE = 2;
    private final int RFACTOR = 2;
    private final double SHRINK_RATIO = 0.50;
    private final double GROW_RATIO = 0.95;

    public GenericAList() {
        items = (Item[]) new Object[DEFAULT_SIZE];
        size = 0;
        offset = DEFAULT_SIZE / RFACTOR;
    }

//IMPLEMENTATION---------------------------------------------------------------------------------------------------------


    @Override
    public void addFirst(Item x) {

        // When adding from the beginning, must decrement offset to push back beginning of list.
        if (shouldGrow()) grow();
        --offset;
        items[offset] = x;
        ++size;
    }

    @Override
    public void addLast(Item x) {
        if (shouldGrow()) grow();
        items[offset + size] = x;
        ++size;
    }

    @Override
    public Item getFirst() {
        return items[offset];
    }

    @Override
    public Item getLast() {
        return items[offset + size - 1];
    }

    @Override
    public Item get(int i) {
        validateIdx(i);
        return items[offset + i];
    }

    @Override
    public Item removeFirst() {
        Item first = getFirst();
        items[offset] = null;
        ++offset;
        --size;
        if (shouldShrink()) shrink();
        return first;
    }

    @Override
    public Item removeLast() {
        Item last = getLast();
        items[size - 1] = null;
        --size;
        if (shouldShrink()) shrink();
        return last;
    }

    @Override
    public Item remove(int i) {
        validateIdx(i);
        Item item = get(i);

        // Create new array of same size as items.
        Item[] a = (Item[]) new Object[items.length];

        // Copy from items [0, i) to a[]
        System.arraycopy(items, offset, a, offset, i);

        // Copy rest of list excluding i | from items [offset + pos + i, size - pos) to a[].
        System.arraycopy(items, offset + i + 1, a,  offset + i, size - i);
        items = a;
        --size;
        if (shouldShrink()) shrink();
        return item;
    }

    @Override
    public void insert(Item x, int pos) {
        validateIdx(pos);

        // Create new array of same size as items.
        Item[] a = (Item[]) new Object[items.length];

        // Copy from items [0, pos) to a[]
        System.arraycopy(items, offset, a, offset, pos);

        // Add new item to end of current list.
        if (shouldGrow()) grow();
        a[offset + pos] = x;
        ++size;

        // Copy rest of list | from items [offset + pos, size - pos) to a[].
        System.arraycopy(items, offset + pos, a,  offset + pos + 1, size - pos);
        items = a;
    }

    @Override
    public void replace(Item x, int pos) {
        validateIdx(pos);
        items[offset + pos] = x;
    }

    @Override
    public int size() {
        return size;
    }

//ALLIST-SPECIFIC--------------------------------------------------------------------------------------------------------

    /** This method will resize items to have a length of the given capacity. */
    private void resize(int capacity) {
        int oldOffset = offset;
        offset = capacity / RFACTOR;
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, oldOffset, a, offset, size);
        items = a;
    }

    /** This method will resize items to be the product of size and RFACTOR. */
    private void grow() {
        resize(items.length * RFACTOR);
    }

    /** This method will resize items to be its current length over RFACTOR. */
    private void shrink() {
        resize(items.length / RFACTOR);
    }

    /** @returns: Ratio of size to items.length */
    private double usageRatio() {
        return ((double)size / (items.length / RFACTOR));
    }

    /** @returns: Ratio of offset to items.length */
    private double offsetRatio() {
        return ((double)offset / (items.length / RFACTOR));
    }

    /** @returns: True if useageRatio() equals one. */
    private boolean shouldGrow() {
        return (usageRatio() > GROW_RATIO || offsetRatio() < (1.0 - GROW_RATIO));
    }

    /** @returns: True if useageRatio() < SHRINK_RATIO */
    private boolean shouldShrink() {
        return (usageRatio() < SHRINK_RATIO);
    }

}
