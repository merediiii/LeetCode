package 搜索;
/*
题目的意思就是二分查找

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1

 */
public class searchInsert {

    public static int[] nums = {1, 3, 5, 7};

    public static int f(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while(low <= high){
            mid = (high + low) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(f(nums,2));
    }
}
