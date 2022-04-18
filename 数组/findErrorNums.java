package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findErrorNums {
    public int[] f(int[] nums) {
        int[] res = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]] += 1;
        }
        int m = 0, n = 0;

        for (int i = 1; i < res.length; i++) {
            if (res[i] == 2) {
                m = i;
            }
            if (res[i] == 0)
                n = i;
        }

        return new int[]{m, n};
    }

    public static void main(String[] args) {
        System.out.println(new findErrorNums().f(new int[]{2, 2}));
    }
}
