package 数组;

import java.util.HashMap;

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

