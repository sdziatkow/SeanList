import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seanList.GenericAList;
import seanList.SeanList;
import time.Timer;

public class TestAList {

    private Timer time = new Timer();
    private SeanList<Integer> list;

    private void makeList() {
        list = new GenericAList<>();
    }
    private void fillFirst(int amnt) {
        for (int i = 0; i < amnt; ++i) {
            list.addFirst(i);
        }
    }
    private void fillLast(int amnt) {
        for (int i = 0; i < amnt; ++i) {
            list.addLast(i);
        }
    }
    private void removeFromStart(int amnt) {
        for (int i = 0; i < amnt; ++i) {
            list.removeFirst();
        }
    }
    private void removeFromEnd(int amnt) {
        for (int i = 0; i < amnt; ++i) {
            list.removeLast();
        }
    }

    @Test
    public void testAddFirst() {
        makeList();
        fillFirst(1);
        list.print();
        fillLast(1);
        list.print();
    }

    @Test
    public void testShrink() {
        time.startTimer();
        makeList();
        fillLast(200);
        list.print();
        removeFromEnd(190);
        list.print();
        time.endTimer();
        time.clearTimer();

    }

    @Test
    public void testRemoveFirst() {
        time.startTimer();
        makeList();
        fillFirst(8);
        list.print();
        removeFromStart(3);
        list.print();
        fillLast(3);
        list.print();
        fillFirst(2);
        list.print();
        time.endTimer();
        time.clearTimer();

    }

}
