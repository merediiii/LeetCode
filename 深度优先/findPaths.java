package 深度优先;

import 数组.findErrorNums;

import java.util.*;

public class findPaths {

    int[][][] board;

    public int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int findPaths(int m, int n, int move, int r, int c) {
        board = new int[m][n][move];
        dp = new int[move][m][n];

        return dfs(m, n, move, r, c);
    }


    public int f(int m, int n, int move, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n) {
            return 1;
        }
        if (0 == move || (m - move > r && r > move - 1 && n - move > c && c > move - 1))
            return 0;

        if (board[r][c][--move] == 0)
            for (int j = 0; j < dir.length; j++) {
                int dx = dir[j][0], dy = dir[j][1];
                board[r][c][move] = (board[r][c][move] + f(m, n, move, r + dx, c + dy)) % ((int) (1e9 + 7));
            }

        return board[r][c][move];
    }

    int mod = (int) 1e9 + 7;
    int m, n;
    int[][][] dp;

    public int dfs(int m, int n, int move, int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n)
            return 1;
        if (move == 0 || (m - move > r && r > move - 1 && n - move > c && c > move - 1))
            return 0;
        if (dp[--move][r][c] == 0)
            for (int i = 0; i < 4; i++) {
                int dx = dir[i][0], dy = dir[i][1];
                dp[move][r][c] = (dp[move][r][c] + dfs(m, n, move, r + dx, c + dy)) % mod;
            }
        return dp[move][r][c];
    }


//    public int findPaths(int m, int n, int move, int r, int c) {
//        return (int) (g(m, n, move, r, c) % (1e9 + 7));
//    }
//
//    public int f(int m, int n, int move, int r, int c) {
//        if (r < 0 || r >= m || c < 0 || c >= n) {
//            return 1;
//        }
//        if (move == 0)
//            return 0;
//        return f(m, n, move - 1, r - 1, c) +
//                f(m, n, move - 1, r + 1, c) +
//                f(m, n, move - 1, r, c - 1) +
//                f(m, n, move - 1, r, c + 1);
//    }


    public int g(int m, int n, int N, int i, int j) {
        int[][][] ans = new int[m][n][N + 1];

        for (int k = 1; k <= N; k++) {
            for (int l = 0; l < m; l++) {
                for (int o = 0; o < n; o++) {
                    if (l == 0) ans[l][o][k]++;
                    if (o == 0) ans[l][o][k]++;
                    if (l == m - 1) ans[l][o][k]++;
                    if (o == n - 1) ans[l][o][k]++;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int l = 0; l < m; l++) {
                for (int o = 0; o < n; o++) {
                    if (l - 1 < 0)
                        ans[l][o][k] += (int) ((ans[l][o][k - 1] % (1e9 + 7) + ans[l + 1][o][k - 1] % (1e9 + 7)) % (1e9 + 7));
                    else if (l + 1 == m && l - 1 >= 0)
                        ans[l][o][k] += (int) ((ans[l][o][k - 1] % (1e9 + 7) + ans[l - 1][o][k - 1] % (1e9 + 7)) % (1e9 + 7));
                    else if (o == 0 && o + 1 < n)
                        ans[l][o][k] += (int) ((ans[l][o][k - 1] % (1e9 + 7) + ans[l][o + 1][k - 1] % (1e9 + 7)) % (1e9 + 7));
                    else if (o + 1 == n && o - 1 >= 0)
                        ans[l][o][k] += (int) ((ans[l][o][k - 1] % (1e9 + 7) + ans[l][o - 1][k - 1] % (1e9 + 7)) % (1e9 + 7));
                    else
                        ans[l][o][k] += (int) ((ans[l][o][k - 1] % (1e9 + 7) + ans[l + 1][o][k - 1] % (1e9 + 7)
                                + ans[l - 1][o][k - 1] % (1e9 + 7) + ans[l][o + 1][k - 1] % (1e9 + 7)
                                + ans[l][o - 1][k - 1] % (1e9 + 7)) % (1e9 + 7));
                    ans[l][o][k] %= 1e9 + 7;
                    System.out.println(ans[l][o][k]);
                }

            }

        }
        return ans[i][j][N];

    }

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        n = n % len;
        String a = f(s, 0, n);
        String b = f(s, n + 1, len);
        return f((a + b), 0, len);

    }

    public String f(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        char[] tmp = s.toCharArray();
        System.out.println(i + "\t" + j);
        for (int k = i; k <= (i + j) / 2; k++) {
            System.out.println(k + "\t" + i + "\t" + j + "\t" + (j - k + i));
            tmp[k] += tmp[j - k + i];
            tmp[j - k + i] = (char) (tmp[k] - tmp[j - k + i]);
            tmp[k] = (char) (tmp[k] - tmp[j - k + i]);
        }

        return new String(tmp).substring(i, j + 1);
    }

    public static void main(String[] args) {
//        System.out.println(new findPaths().findPaths(8, 50, 23, 5, 26));
        String s = "123";
        char[] ary = s.toCharArray();
        System.out.println(ary[4]);
    }
}
