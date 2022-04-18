package 数组;

import java.util.Arrays;
import java.util.HashMap;

public class minAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] diff = new int[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
        }
        if (sum == 0)
            return 0;
        long min = 0;
        int x = 0, y = 0;
        int[] sort = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(sort);
        for (int i = 0; i < len; i++) {
            if (nums1[i] == nums2[i]) continue;
            int l = 0, r = len - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sort[mid] <= nums2[i]) l = mid;
                else r = mid - 1;
            }
            if (diff[i] - Math.abs(sort[l] - nums2[i]) > min) {
                x = sort[l];
                y = i;
                min = diff[i] - Math.abs(sort[l] - nums2[i]);
            }
            if (l + 1 < len && diff[i] - Math.abs(sort[l + 1] - nums2[i]) > min) {
                x = sort[l + 1];
                y = i;
                min = diff[i] - Math.abs(sort[l + 1] - nums2[i]);
            }

        }
        return (int) ((sum - Math.abs(nums1[y] - nums2[y]) + Math.abs(x - nums2[y])) % (1e9 + 7));
    }
}
