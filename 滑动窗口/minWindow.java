package 滑动窗口;

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
        int[] tdic = new int[128 - 65];
        int[] sdic = new int[128 - 65];
        char[] dic = t.toCharArray();
        String res = "";
        int len = 0x7fffffff;
        for (int i = 0; i < dic.length; i++) {
            tdic[dic[i] - 65]++;
        }
        sdic[s.charAt(0) - 65] = 1;
        int left = 0, right = 0;
        int mark = 0;
        int z = 0;
//        HashMap<String, Integer> res = new HashMap<>();
        if (s.length() < t.length())
            return "";
        if (s.equals(t))
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(left));
        while (left <= s.length() - t.length()) {
            System.out.println(left + " " + (right + 1));
            System.out.println(sb);
            mark = 0;
            for (int i = 0; i < sdic.length; i++) {
                if (tdic[i] > sdic[i]) {
                    mark = 1;
                    break;
                }
            }
            if (mark == 1) {
                if (right < s.length()) {
                    right++;
                    if (right == s.length())
                        break;
                    sb.append(s.charAt(right));
                    sdic[s.charAt(right) - 65]++;
                    continue;
                }
            } else {
                left++;
                sdic[s.charAt(left - 1) - 65]--;
                if (z++ == 0)
                    res = sb.length() < len ? sb.toString() : res;
                else
                    res = sb.length() < res.length() ? sb.toString() : res;
                sb.delete(0, 1);
            }
        }
        return res;
    }

    public static String g(String s, String t) {
        char[] dic = new char[128];
        for (int i = 0; i < t.length(); i++) {
            dic[t.charAt(i)]++;
        }
        char[] sdic = s.toCharArray();
        char[] win = new char[128];
        win[s.charAt(0)]++;
        String res = "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char target;
        int left = 0, right = 0, flag = 0, max = 0x7fffffff;
        while (left < s.length() - t.length() + 1) {
            for (int i = 0; i < win.length; i++) {
                if (win[i] < dic[i]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                if (right < s.length()) {
                    right++;
                    if (right == s.length())
                        return res;
                    target = s.charAt(right);
                    win[target]++;
                    sb.append(target);
                }
            } else {
                if (max > sb.length()) {
                    max = sb.length();
                    res = sb.toString();
                }
                sb.delete(0, 1);
                win[s.charAt(left)]--;
                left++;
            }
            flag = 0;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(g("ADOBECODEBANC",
                "ABC"));
        System.out.println(0x3f3f3f3f);
    }
}