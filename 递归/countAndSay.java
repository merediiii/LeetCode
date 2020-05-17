package 递归;

import javax.management.StandardEmitterMBean;
import java.util.Arrays;

/*
38. 外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。

示例 1:

输入: 1
输出: "1"
解释：这是一个基本样例。
示例 2:

输入: 4
输出: "1211"
解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class countAndSay {

    public static String[] res = new String[30];

    public static String f(int n) {
        Arrays.fill(res, "");
        res[0] = "1";
        res[1] = "11";
        return g(n, res);
    }

    public static String g(int n, String[] res) {
        if (n == 1) return res[0];
        if (n == 2) return res[1];
        String s = g(n - 1, res);
        int p = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                p++;
            else {
                res[n - 1] += Integer.toString(p);
                res[n - 1] += Character.toString(s.charAt(i - 1));
                p = 1;
            }
        }
        res[n - 1] += Integer.toString(p);
        res[n - 1] += s.charAt(s.length() - 1);
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
