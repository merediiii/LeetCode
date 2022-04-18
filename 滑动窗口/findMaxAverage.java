package 滑动窗口;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class findMaxAverage {
    public double f(int[] nums, int k) {
        int i = 0;
        int j = i + k - 1;
        int sum = 0;
        int max = 0;
        for(int l = 0;l < k ;l ++){
            sum += nums[l];
        }
        max = sum;
        while(j < nums.length){
            sum -= nums[i];
            if(j + 1 < nums.length)
                sum += nums[++j];
            else
                return (double)max / k;
            max = Math.max(sum,max);
            i++;
        }
        return 0;
    }
}
