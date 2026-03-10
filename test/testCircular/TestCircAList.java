package testCircular;

import circularLists.CircAList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCircAList {
    private CircAList<Integer> l = new CircAList<>();

    @Test
    public void testAdd() {
        for (int i = 0; i < 10; ++i) {
            l.addFirst(i);
        }
        System.out.println(l.getLast());
        System.out.println();
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 15; ++i) {
            l.addFirst(i);
        }
        Integer e = 0;
        assertEquals(e, l.removeLast());
        e = 14;
        assertEquals(e, l.removeFirst());
    }



}
