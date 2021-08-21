package 贪心;

import java.util.Arrays;

public class maxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        int[] cost = new int[costs.length];
        Arrays.sort(costs);
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            if (sum + costs[i] > coins)
                break;
            sum += costs[i];
            cnt++;

        }
        return cnt;
    }
}
