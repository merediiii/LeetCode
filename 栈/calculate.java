package 栈;

import java.util.Stack;

// 224. 基本计算器
public class calculate {
    public int f(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<Character> op = new Stack<>();
        s = s.replace(" ", "");
        char[] sc = s.toCharArray();
        int left = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') left++;
            else if (sc[i] == '+' || sc[i] == '-')
                op.push(sc[i]);
            else if (sc[i] == ')') {
                while (left != 0) {
                    int m = stk.pop();
                    int n = stk.pop();
                    Character cal = op.pop();
//                    if cal
                }
            } else
                stk.push((int) sc[i]);

        }
        return 0;
    }
}
