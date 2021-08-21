package 搜索;

import java.util.Arrays;

public class ShipWithinDays {


    public int f(int[] weights, int D) {
        int sum = 0;
        int max = 0x7fffffff;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        while (max < sum) {
            int mid = (sum + max) >> 1;
            int cnt = 0;
            int slice = 1;
            for (int i = 0; i < weights.length; i++) {
                if (cnt + weights[i] > mid) {
                    slice++;
                    cnt = 0;
                }
                cnt += weights[i];
            }
            if (slice > D)
                max = mid + 1;
            else
                sum = mid;

        }
        return max;
    }
}
