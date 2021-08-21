package 搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class canCross {

    List<Boolean> path;
    List<Integer> part;
    List<List<Integer>> dp;
    int k = 1;
    HashMap<Integer, Integer> map;

    public void dfs(int[] stones, int index, int sum, int k) {
        if (sum == stones[stones.length - 1]) {
            dp.stream().forEach(name -> System.out.println(name));
            dp.add(new ArrayList<>(part));
            path.add(true);
            return;
        }
        if (index >= stones.length) {
            dp.add(part);
            return;
        }

        for (int K : new int[]{k - 1, k, k + 1}) {
            sum += K;
            if (map.containsKey(sum)) {
                part.add(sum);
                dfs(stones, map.get(sum), sum, k);
                part.remove(part.size() - 1);
            }
            sum -= K;
        }
        return;
    }

    public boolean f(int[] stones) {
        path = new ArrayList<>();
        dp = new ArrayList<>();
        part = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        if (stones.length >= 3)
            if (stones[2] == 3)
                dfs(stones, 2, 3, 2);
            else
                return false;
        return !path.isEmpty();
    }

    public boolean g(int[] stones) {
        if (stones[1] != 1) return false;
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= j + 1) {
                    dp[i][k] = dp[j][k - 1] | dp[j][k] | dp[j][k + 1];
                    //提前结束循环直接返回结果
                    if (i == stones.length - 1 && dp[i][k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 7};
//        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(new canCross().f(stones));
    }
}
