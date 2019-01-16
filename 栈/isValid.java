package 栈;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
import java.util.Stack;

public class isValid {
    public static boolean f(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char a:chars){
            if (stack.isEmpty()) stack.push(a);
            else if(stack.peek()=='(' && a ==')' || stack.peek()=='[' && a ==']' || stack.peek()=='{' && a =='}'){
                stack.pop();
            }
            else
                stack.push(a);
//            if(i==chars.length) break;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(f("[][][]"));
    }
}
