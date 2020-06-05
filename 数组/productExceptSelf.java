package 数组;
/*
238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class productExceptSelf {
    public static int[] f(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int[] c = new int[nums.length];
        a[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            a[i] = a[i-1] * nums[i];
            System.out.print(a[i] + " ");
        }
        System.out.println();
        b[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i >= 0;i--){
            b[i] = b[i+1] * nums[i];
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for(int i = 0;i < nums.length;i++){
            if(i == 0)
                c[i] = b[1];
            else if(i == nums.length -1)
                c[i] = a[nums.length - 2];
            else
                c[i] = a[i-1] * b[i+1];
        }
        return c;
    }

    //空间复杂度更低的版本
    public static int[] g(int[] nums){
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for(int i=0;i<len;i++){
            output[i] = left;
            left *= nums[i];
        }
        for(int j=len-1;j>=0;j--){
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{1,2,3,4}));
    }
}
