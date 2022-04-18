package 数组;

import java.util.Arrays;

public class arrayPairSum {
    public int f(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    public static int g(int[] nums) {
        int[] len = new int[20001];
        boolean zero = false;
        for (int i = 0; i < nums.length; i++) {
            len[nums[i] + 10000]++;

            if (nums[i] < 0)
                zero = true;
        }
        int count = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < len.length; i++) {
            if (len[i] != 0) {
                if (len[i] % 2 == 0 && count == 0) {
                    sum += (i - 10000) * len[i] / 2;
                    cnt++;
                    count = 0;
                } else if (len[i] % 2 == 0 && count == 1) {
                    sum += (i - 10000) * len[i] / 2;
                    cnt++;
                    count = 1;
                } else if (len[i] % 2 == 1 && count == 0) {
                    sum += (i - 10000) * (len[i] + 1) / 2;
                    cnt++;
                    count = 1;
                } else {
                    sum += (i - 10000) * (len[i] - 1) / 2;
                    cnt++;
                    count = 0;
                }
                System.out.println(sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(g(new int[]{1, 4, 3, 2}));
    }
}
