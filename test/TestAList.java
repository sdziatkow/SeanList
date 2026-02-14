import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seanList.GenericAList;
import seanList.GenericSList;
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
    private void removeFromEnd(int amnt) {
        for (int i = 0; i < amnt; ++i) {
            list.removeLast();
        }
    }

    @Test
    public void testAddFirst() {
        makeList();
        fillLast(1);
        list.print();
        fillFirst(1);
        list.print();
    }

    @Test
    public void testShrink() {
        makeList();
        fillLast(1000000);
        list.print();

    }

}
