package 栈;

import java.util.*;

public class generateParenthesis {
    public List<String> f(int n) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < n; i++) {
            left.push('(');
            right.push(')');
        }
        Deque<Character> combine = new ArrayDeque<>();
        combine.add(left.pop());

        return null;
    }
}
