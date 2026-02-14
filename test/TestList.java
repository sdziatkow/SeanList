import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seanList.GenericAList;
import seanList.GenericSList;
import seanList.SeanList;
import time.Timer;

public class TestList {
    Timer time = new Timer();
    public enum ListType {AL, SLL};
    private SeanList<Integer> list;

    private final ListType TYPE = ListType.AL;
    private void makeListAddFirst() {
        switch (TYPE) {
            case AL: list = new GenericAList<>();
            break;
            case SLL: list = new GenericSList<>();
            break;
        }
        for (int i = 0; i < 10; ++i) {
            list.addFirst(i);
        }
    }
    private void makeListAddLast() {
        switch (TYPE) {
            case AL: list = new GenericAList<>();
            break;
            case SLL: list = new GenericSList<>();
            break;
        }
        for (int i = 0; i < 10; ++i) {
            list.addLast(i);
        }
    }

//SLLIST-----------------------------------------------------------------------------------------------------------------

    @Test
    public void testAddFirst() {
        makeListAddFirst();
        list.addFirst(100);
        list.addFirst(200);
        list.print();
        int exp = 200;
        int act = list.getFirst();
        assertEquals(exp, act);
    }

    @Test
    public void testAddLast() {
        makeListAddLast();
        list.addLast(100);
        list.print();
        int exp = 100;
        int act = list.getLast();
        assertEquals(exp, act);
    }

    @Test
    public void testGet() {
        makeListAddLast();
        list.print();
        int exp = 2;
        int act = list.get(2);
        assertEquals(exp, act);
    }

    @Test
    public void testInsert() {
        makeListAddLast();
        list.print();
        list.insert(3, 4);
        list.print();
        int exp = 3;
        int act = list.get(4);
        assertEquals(exp, act);
    }

    @Test
    public void testRemoveLast() {
        makeListAddLast();
        list.print();
        int exp = 9;
        int act = list.removeLast();
        list.print();
        assertEquals(exp, act);
    }

    @Test
    public void testRemoveFirst() {
        makeListAddLast();
        list.print();
        int exp = 0;
        int act = list.removeFirst();
        list.print();
        assertEquals(exp, act);
    }

    @Test
    public void testRemove() {
        time.startTimer();
        makeListAddLast();
        list.print();
        int exp = 5;
        int act = list.remove(5);
        list.print();
        time.endTimer();
        assertEquals(exp, act);
    }
}
