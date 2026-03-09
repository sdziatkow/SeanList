package testCircular;

import circularLists.CircAList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testCircAList {
    private CircAList<Integer> l = new CircAList<>();

    @Test
    public void testAdd() {
        for (int i = 0; i < 10; ++i) {
            l.addFirst(i);
        }
        for (int i = 0; i < 10; ++i) {
            l.addLast(i + 10);
        }
        System.out.println();
    }



}
