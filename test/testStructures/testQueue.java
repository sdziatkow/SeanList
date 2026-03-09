package testStructures;

import structures.Queue;
import structures.Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testQueue {
    private Queue<Integer> q = new Queue<>();

    @Test
    public void testEnqueue() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Integer e = 1;
        Integer a = q.peek();
        assertEquals(e, a);
    }

    @Test
    public void testDequeue() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        Integer e = 2;
        Integer a = q.peek();
        assertEquals(e, a);
    }
}
