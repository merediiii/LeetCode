package 数组;

public class numWays {
    public int f(int steps, int arrLen) {
        if (arrLen == 1 || steps == 1) {
            return 1;
        }
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps + 1][max + 1];

        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = max; j >= 0; j--) {
                dp[i][j] = (int) ((dp[i - 1][j] % (1e9 + 7) + (j == 0 ? 0 : dp[i - 1][j - 1]) % (1e9 + 7) + (j == max ? 0 : dp[i - 1][j + 1]) % (1e9 + 7)) % (1e9 + 7));
            }
        }
        return dp[steps][0];
    }

    int mod = (int) 1e9 + 7;

    public int g(int steps, int len) {
        int max = Math.min(steps / 2, len - 1);
        int[][] f = new int[steps + 1][max + 1];
        f[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(i, max);
            // if (edge != max) System.out.println(edge + " " + max);
            for (int j = 0; j <= edge; j++) {
                f[i][j] = (f[i][j] + f[i + 1][j]) % mod;
                if (j - 1 >= 0) f[i][j] = (f[i][j] + f[i + 1][j - 1]) % mod;
                if (j + 1 <= max) f[i][j] = (f[i][j] + f[i + 1][j + 1]) % mod;
            }
        }
        return f[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new numWays().f(2, 7));
    }
}
