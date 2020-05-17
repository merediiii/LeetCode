package 字符串;

import java.util.Arrays;
import java.util.HashMap;

/*
76. 最小覆盖子串
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minWindow {
    public static String f(String s, String t) {
        int[] compare = new int[128];
        int[] frequency = new int[128];
        int left = 0, right = 0;
        if (s.length() < t.length()) return "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            frequency[t.charAt(i)]++;
        }
        int flag = 0;
        while (right < s.length()) {
            for (int i = left; i < right; i++) {

                compare[s.charAt(i)]++;
            }
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] > compare[i])
                    flag = 1;
            }
            if (flag == 1) {
                right++;
                continue;
            } else {
                map.put(s.substring(left, right), right - left + 1);
                left++;
            }

        }


        return "0";
    }


    public static void main(String[] args) {
        System.out.println(f("ADOBECODEBANC", "ABC"));
    }
}