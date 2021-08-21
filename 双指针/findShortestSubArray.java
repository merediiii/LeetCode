package 双指针;

import java.util.ArrayList;
import java.util.HashMap;

public class findShortestSubArray {
    public static int f(int[] nums) {
        int[][] res = new int[2][nums.length];
        int[] temp = new int[50000];
        int[] sta = new int[50000];
        int max = nums.length;
        ArrayList<Integer> re = new ArrayList<>();
        int most = 0;
        for (int i = 0; i < nums.length; i++) {
            sta[nums[i]]++;
            most = Math.max(most, sta[nums[i]]);
        }
//        System.out.println(most);
        for (int i = 0; i < nums.length; i++) {
            if (sta[nums[i]] == most)
                if (!re.contains(nums[i])) re.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp[nums[i]] == 0) {
                res[0][i] = i;
                temp[nums[i]] = i + 1;
            } else
                res[0][i] = temp[nums[i]] - 1;

            if (temp[nums[i]] != 0)
                res[1][i] = i;
//            System.out.println(res[0][i]+"\t"+res[1][i]);

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < re.size(); j++) {
                if (re.get(j) == nums[i]) {
                    max = Math.min(res[1][i] - res[0][i] + 1, max);
                    re.remove(j);
                    break;
                }

            }
            if (re.size() == 0)
                break;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{1, 2, 2, 3, 1}));
    }
}
