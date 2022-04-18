package 数组;

/*
424. 替换后的最长重复字符
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过 104。



示例 1：

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
 */
public class characterReplacement {

    public static void p(Object[] obj) {
        for (Object b : obj) {
            System.out.print(b + "\t");
        }
        System.out.println();
    }

    public static int f(String s, int k) {
        int l = 0;
        int r = 0;
        int len = s.length();
        int[] dic = new int[26];
        int max = 0;
        while (r < len) {
            dic[s.charAt(r) - 'A']++;
            max = Math.max(max, dic[s.charAt(r) - 'A']);
            if (r - l + 1 - max > k) {
                dic[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(f(s, k));
    }
}
