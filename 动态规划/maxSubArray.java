package 动态规划;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class maxSubArray {
    public static int f(int[] nums) {
        int r = 0,a = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            r = Math.max(r + nums[i] , nums[i]);    //遍历一遍nums数组,取第i个前的最大递增子序列,和第i个之间的大者,即为当前的最大递增子序列
                                                    //主要是用于nums[i]>0的场景,还有就是在r从 < 0 变到 > 0 时会宠重新开始计算(在不全为0的数组当
                                                    // 中,最大递增子序列的两端必然不包含负数)
            if(a < r) a = r ;                       //记录最大的递增子序列的值
        }
        return a;
    }

    public static void main(String[] args){
        //int[] test = new int[]{1, 2, 32, 13, 34, 72, 45, 37, 44, 1, 63, 62, 9, 73, 5, 4, 2, 1};
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(f(test));
    }
}
