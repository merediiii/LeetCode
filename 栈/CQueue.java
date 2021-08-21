package 栈;

import java.util.Stack;

public class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty() && s2.isEmpty())
            return -1;
        if (s2.isEmpty())
            while (!s1.isEmpty()) {
                int a = s1.pop();
                s2.push(a);
            }

        return s2.pop();
    }
}
