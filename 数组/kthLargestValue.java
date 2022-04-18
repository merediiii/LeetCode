package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestValue {
    public int f(int[][] matrix, int k) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1];
                pq.add(dp[i][j]);
            }
        }
        Integer[] res = pq.toArray(new Integer[0]);
        Arrays.sort(res);
        return res[res.length - k];
    }
}
