package 字符串;

import java.util.HashMap;

public class longestPalindrome {

    public static String f(String s) {
        int len = s.length();
        if (len == 0 || len == 1)
            return s;
        boolean[][] dp = new boolean[len][len];
        char[] dic = s.toCharArray();
        int max = 1, left = 0;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                dp[i][j] = i == j ? true : false;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dic[j] == dic[i])
                    if (i - j < 3)
                        dp[j][i] = true;
                    else
                        dp[j][i] = dp[j + 1][i - 1];

                if (dp[j][i] == true) {
                    if (i - j + 1 > max) left = j;
                    max = i - j + 1 > max ? i - j + 1 : max;

                }
            }
        }
        return s.substring(left, max + left);
    }

    public static void main(String[] args) {
        System.out.println(f("cbbd"));
    }

}
