package testCircular;

import circularLists.LinkedDeque;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestLinkedDeque {
    LinkedDeque<Integer> l = new LinkedDeque<>();

    @Test
    public void testAddFirst() {
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        String e = "[3, 2, 1]";
        assertEquals(e, l.toString());
    }

    @Test
    public void testAddLast() {
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        String e = "[1, 2, 3]";
        assertEquals(e, l.toString());
    }

    @Test
    public void testRemoveFirst() {
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.removeFirst();
        String e = "[2, 3]";
        assertEquals(e, l.toString());
    }
}
