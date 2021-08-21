package 数学;

import java.util.*;

public class threeSum {
    public static List<List<Integer>> f(int[] nums) {
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3)
            return res;
        int j = 1, k = 2;
        Set<List<Integer>> set = new HashSet<>();
        for (; i <= len - 3; i++) {
            for (j = i + 1; j <= len - 2; j++) {
                for (k = j + 1; k <= len - 1; k++) {
                    System.out.println(i + " " + j + " " + k);
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(ans);


                        if (!set.contains(ans)) {
                            set.add(ans);
                            res.add(ans);
                        }

                    }
                    break;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> g(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        int len = nums.length;
        if (len < 3)
            return list;
        int j = 1, k = len - 1;
        for (; i < len - 2; i++) {
            while (i != j)
                if (nums[i] == nums[j] + nums[k]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    list.add(ans);

                } else if (nums[i] < nums[j] + nums[k])
                    k--;
                else
                    j++;

        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(f(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
