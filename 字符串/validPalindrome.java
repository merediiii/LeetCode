package 字符串;

import sun.awt.windows.WPrinterJob;

/*

680. 验证回文字符串 Ⅱ

给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:
输入: "aba"
输出: True

示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。
注意:

字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class validPalindrome {
    public static boolean f(String s) {
        int len = s.length(), left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right])
                return g(s, left + 1, right) || g(s, left, right - 1);
            left++;
            right--;
        }
        return true;
    }

    public static boolean g(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(f("abcsa"));
    }
}
