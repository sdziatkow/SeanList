package testStructures;

import structures.Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestStack {
    private Stack<Integer> s = new Stack<>();

    @Test
    public void testPush() {
        s.push(1);
        s.push(2);
        Integer e = 2;
        assertEquals(e, s.peek());
    }

    @Test
    public void testPop() {
        s.push(1);
        s.push(2);
        Integer e1 = 2;
        Integer a1 = s.pop();
        assertEquals(e1, a1);

        Integer e2 = 1;
        Integer a2 = s.peek();
        assertEquals(e2, a2);
    }

    @Test
    public void testSearch() {
        s.push(1);
        s.push(2);
        s.push(3);
        int e = 0;
        int a = s.search(3);
        assertEquals(e, a);

        e = 2;
        a = s.search(1);
        assertEquals(e, a);
    }

    @Test
    public void testToString() {
        s.push(1);
        s.push(2);
        s.push(3);
        String e = "[3, 2, 1]";
        assertEquals(e, s.toString());
    }
}
