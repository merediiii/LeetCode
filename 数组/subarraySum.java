package 数组;

import java.util.HashMap;

/*
560. 和为K的子数组
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
    public static int g(int[] nums, int k) {
        int len = nums.length, count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);                                      //此处表示前缀和为0，且用于标识和等于本身的元素
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static int k(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            max = max > nums[i] ? max : nums[i];
            min = min < nums[i] ? min : nums[i];
        }
        int count = 0;
        int map[] = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                count++;
            }
            if (nums[i] - k >= min && nums[i] - k <= max) {
                count += map[nums[i] - k - min];
            }
            map[nums[i] - min]++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(k(new int[]{1, 1, -1, 0, 3, 2, -1, 2, 1}, 2));

    }
}

