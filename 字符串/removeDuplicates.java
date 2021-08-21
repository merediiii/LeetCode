package 字符串;

import java.util.Stack;

public class removeDuplicates {
    public static String f(String S) {
        Stack<Character> stk = new Stack<>();
        Stack<Character> res = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stk.isEmpty() && S.charAt(i) == stk.peek()) {
                stk.pop();
                continue;
            }
            stk.push(S.charAt(i));
        }
        while (!stk.isEmpty()) {
            res.push(stk.pop());
        }
        String ans = "";
        while (!res.isEmpty()) {
            ans += res.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(f("abbaca"));
    }
}
