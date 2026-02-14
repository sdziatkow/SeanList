import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seanList.GenericAList;
import seanList.SeanList;

public class TestAList {

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
        makeList();
        fillLast(1000);
        list.print();
        removeFromEnd(900);
        list.print();

    }

    @Test
    public void testRemoveFirst() {
        makeList();
        fillFirst(8);
        list.print();
        removeFromStart(3);
        list.print();
        fillLast(3);
        list.print();
        fillFirst(2);
        list.print();

    }

}
