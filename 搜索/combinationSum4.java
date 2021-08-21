package 搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum4 {

    List<List<Integer>> list;
    List<Integer> tmp;

    public void dfs(int[] nums, int target, int index, int sum) {
        if (sum >= target) {
            if (sum > target)
                return;
            else {
                list.add(new ArrayList(tmp));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            sum += nums[i];
            tmp.add(nums[i]);
            dfs(nums, target, i + 1, sum);
            sum -= nums[i];
            tmp.remove(tmp.size() - 1);
        }
    }

    public int f(int[] nums, int target) {
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(nums, target, 0, 0);
        return list.size();
    }

    public int[] dp;

    public int g(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] > target)
            return 0;
        dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public int h(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] > target)
            return 0;
        dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public int j(int n) {
        int[] nums = {1, 5, 10, 25};
        dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new combinationSum4().f(new int[]{1, 2, 3}, 4));
        System.out.println(new combinationSum4().g(new int[]{1, 2, 3}, 4));
        System.out.println(new combinationSum4().h(new int[]{1, 2, 3}, 4));
    }
}
