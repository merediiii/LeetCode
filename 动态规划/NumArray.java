package 动态规划;

/*
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

说明:
    1)你可以假设数组不可变。
    2)会多次调用 sumRange 方法。
 */

public class NumArray {

    public int[] r;

    public NumArray(int[] nums) {
        r = new int[nums.length];
        if(nums.length == 0) return;
        r[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
            r[i] += r[i-1] + nums[i];           //r[i]记录的是从r[0]到r[i]的值的和,因为r[i]=r[i-1]+nums[i]
    }

    public int sumRange(int i, int j) {
        //其实有两个思路,第一个就是每次都调用迭代,然后将nums[i]加到nums[j],但是显然多次相加了,时间开销必然太大
        //故用数组r[i]存储,取数字的时间开销O(n)为1,故计算r[i]到r[j]的值的和,可由r[j]-r[i-1]表示,
        //接着考虑i等于0的时候会越界,对i等于0再处理,即r[j]记录的是从r[0]到r[j]的值的和
        return i==0?r[j]:r[j] - r[i-1];
    }
}
