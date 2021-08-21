package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class maxEnvelopes {
    public static int f(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        dp[0] = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int max = 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        for (int i = 0; i < envelopes.length; i++) {
//            System.out.println(envelopes[i][0]+"\t"+envelopes[i][1]);
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(1 + dp[j], dp[i]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int g(int[][] envelopes) {
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + "\t" + envelopes[i][1]);
        }
        for (int[] env : envelopes) {
            int lo = 0, hi = maxL;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (dp[mid] < env[1])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            dp[lo] = env[1];
            if (lo == maxL)
                maxL++;
            for (int i = 0; i < dp.length; i++) {
                System.out.print(dp[i] + " ");

            }
            System.out.println();
            System.out.println(maxL + "\t" + lo);
        }
        return maxL;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{5, 3}, {8, 4}, {6, 7}, {2, 3}, {5, 7}, {5, 5}, {5, 6}};
        System.out.println(g(res));
    }
}
