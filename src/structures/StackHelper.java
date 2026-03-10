package structures;

public class StackHelper {

    public static boolean isParenthesesBalanced(String p) {
        Stack<Character> checker = new Stack<>();
        char currChar;

        for (int i = 0; i < p.length(); ++i) {
            currChar = p.charAt(i);
            if (currChar == '(') {
                checker.push(currChar);
            }
            else if (checker.isEmpty()) {
                return false;
            }
            else if (currChar == ')') {
                checker.pop();
            }
        }
        return checker.isEmpty();
    }

    public static <T> Queue<T> reverseQueue(Queue<T> q) {
        Stack<T> reversed = new Stack<>();
        while (!q.isEmpty()) {
            reversed.push(q.dequeue());
        }
        while (!reversed.isEmpty()) {
            q.enqueue(reversed.pop());
        }
        return q;
    }
}
