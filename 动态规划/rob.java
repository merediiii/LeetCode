package 动态规划;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
/*
    未优化之前的暴力递归
            public int solve(int i , int[] n){
                if(i < 0) return 0;
                return Math.max(solve(i - 1 , n) , n[i] + solve(i - 2 , n));
            }

            public int rob(int[] nums) {
                return solve(nums.length - 1, nums);
            }
 */
public class rob {

    public static int[] n;

    public static int solve(int i, int[] nums) {
        if (i < 0) return 0;
        if (n[i] >= 0) return n[i];                                             //记忆化搜索
        n[i] = Math.max(solve(i - 1, nums), solve(i - 2, nums) + nums[i]); //自顶向下
        return n[i];
    }

    public static int f1(int[] nums) {
        n = new int[nums.length];
        for (int i = 0; i < n.length; i++)
            n[i] = -1;
        return solve(nums.length - 1, nums);
    }

    public static int f2(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        n = new int[nums.length];
        n[0] = nums[0];
        n[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length;i++)
            n[i] = Math.max(nums[i] + n[i - 2],n[i - 1]);
        return n[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 1, 4, 7, 5, 7, 4, 1, 6, 6, 9, 7, 5, 4, 2, 1};
        System.out.println(f1(test));
        System.out.println(f2(test));
    }
}