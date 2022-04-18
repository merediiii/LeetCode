package 动态规划;

public class longestCommonSubsequence {
    public static int f(String text1, String text2) {
        int a = text1.length();
        int b = text2.length();
        int[][] dp = new int[b + 1][a + 1];
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= a; j++) {

                if (text2.charAt(i - 1) == text1.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[b][a];
    }

    public static void main(String[] args) {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";

        System.out.println(f(text1, text2));
    }
}
