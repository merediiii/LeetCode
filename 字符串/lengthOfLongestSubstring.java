package 字符串;

import java.util.Arrays;
import java.util.HashMap;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lengthOfLongestSubstring {

    //执行用时 :30 ms, 在所有 Java 提交中击败了18.92%的用户
    public static int f(String s) {
        HashMap<String, Integer> dic = new HashMap<>();
        char[] cha = s.toCharArray();
        int len = cha.length, max = 0;
        if (len == 0)
            return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (dic.containsKey(s.charAt(i)+"")) {
                dic.put(sb.toString(), sb.length());
                max = max > sb.length() ? max : sb.length();
                int pos = sb.indexOf(s.charAt(i)+"");
                sb.delete(0, pos + 1);
                sb.append(s.charAt(i));
            } else {
                dic.put(s.charAt(i)+"", 1);
                max = 1 > max?1:max;
                sb.append(s.charAt(i));
            }
        }
        if (!dic.containsKey(sb))
            max = max > sb.length() ? max : sb.length();
        return max;
    }

    //执行用时 :4 ms, 在所有 Java 提交中击败了90.49%的用户
    //滑动窗口快很多
    public static int g(String s){
        int left = 0,right = 0;
        int res = 0;
        int[] location = new int[128];
        Arrays.fill(location,-1);
        int len = s.toCharArray().length;
        for (int i = 0; i < len ; i++){
            if(location[s.charAt(i)] >= 0)                          //讲道理
                left = Math.max(left,location[s.charAt(i)] + 1);
            res = Math.max(res, i - left + 1);
            location[s.charAt(i)] = i;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(g("abba"));
    }
}
