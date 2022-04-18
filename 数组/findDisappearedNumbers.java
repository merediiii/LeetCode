package 数组;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> f(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i);
        }
        return res;
    }
}
