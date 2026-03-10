package testStructures;

import org.junit.Test;

import structures.Queue;
import structures.Stack;
import structures.StackHelper;

import static org.junit.Assert.*;

public class TestStackHelper {

    @Test
    public void testIsParenBalanced() {
        String t1 = "(())";
        String t2 = "()";
        String t3 = "((()))";
        String f1 = ")(";
        String f2 = "())";
        String f3 = "(()(";

        assertTrue(StackHelper.isParenthesesBalanced(t1));
        assertTrue(StackHelper.isParenthesesBalanced(t2));
        assertTrue(StackHelper.isParenthesesBalanced(t3));

        assertFalse(StackHelper.isParenthesesBalanced(f1));
        assertFalse(StackHelper.isParenthesesBalanced(f2));
        assertFalse(StackHelper.isParenthesesBalanced(f3));
    }

    @Test
    public void testReverseQueue() {
        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);

        q2.enqueue(3);
        q2.enqueue(2);
        q2.enqueue(1);
        assertEquals(q2.toString(), StackHelper.reverseQueue(q1).toString());
    }
}
