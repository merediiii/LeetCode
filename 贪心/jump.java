package 贪心;

import java.util.Arrays;

/*
45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
 */
public class jump {
    public static int f(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums.length == 1) return 0;
        Arrays.fill(dp, nums.length - 1);
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = nums[i - 1];
//        }
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= nums[i - 1]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                if (i + j == nums.length)
                    return dp[i + j];
            }
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
    }

}
