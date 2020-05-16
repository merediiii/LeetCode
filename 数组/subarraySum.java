package 数组;

import java.util.HashMap;

/*

给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class subarraySum {
    //o(n^2)
    public static int f(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int count = 0;
        ans[0] = nums[0];
        if(nums.length == 1)
            if(nums[0] == k)
                return 1;
            else
                return 0;
        for (int i = 1; i < nums.length; i++) {
            ans[i] +=ans[i-1] + nums[i];

        }
        for (int i = 0; i < nums.length; i++) {
            if(ans[i] == k)
                count++;
            for (int j = i + 1; j < nums.length; j++) {
                if (ans[j] == ans[i] + k) {
                    count++;
                }
            }
        }
        return count;
    }

    //O(n)
    public static int g(int[] nums, int k){
        int left = 0,right = 1, count = 0,ans = 0 ;
        int[] temp = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            
        }
        
    }


    public static void main(String[] args) {
        System.out.println(f(new int[]{1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2}, 1));
    }
}

