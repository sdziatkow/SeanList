package structures;

/**
 * FIFO - FIRST IN, FIRST OUT.
 * @param <T>: Type of Object to be stored.
 */
public class Queue<T> {

    private final Stack<T> IN_STACK;
    private final Stack<T> OUT_STACK;

    public Queue() {
        IN_STACK = new Stack<>();
        OUT_STACK = new Stack<>();
    }

    /** Transfer contents of OUT_STACK to IN_STACK, reversing the order of the elements. */
    private void updateInStack() {
        while (!OUT_STACK.isEmpty()) {
            IN_STACK.push(OUT_STACK.pop());
        }
    }

    /** Transfer contents of IN_STACK to OUT_STACK, reversing the order of the elements. */
    private void updateOutStack() {
        while (!IN_STACK.isEmpty()) {
            OUT_STACK.push(IN_STACK.pop());
        }
    }

    /**
     * This method will add the given Object to the end of the queue.
     * @param x: Object to be added.
     */
    public void enqueue(T x) {
        updateInStack();
        IN_STACK.push(x);
    }

    /**
     * This method will REMOVE and RETURN the Object at the beginning of the Queue.
     * @Return: The Object at the beginning of the Queue.
     */
    public T dequeue() {
        updateOutStack();
        return OUT_STACK.pop();
    }

    /** @Return: The Object at the beginning of the Queue. */
    public T peek() {
        updateOutStack();
        return OUT_STACK.peek();
    }

    /** @Return: True if the Queue contains no Objects. */
    public boolean isEmpty() {
        return (IN_STACK.isEmpty() && OUT_STACK.isEmpty());
    }

    @Override
    public String toString() {
        updateOutStack();
        return OUT_STACK.toString();
    }
}
