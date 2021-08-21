package 深度优先;

import java.util.*;

public class miniumTimeRequired {

    List<List<Integer>> list;
    List<Integer> tmp;
    int[] a;

    public void f(int[] nums, int index) {
        if (tmp.size() == nums.length) {
            if (!list.contains(tmp)) list.add(new ArrayList(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (a[i] == 1 || i > index && nums[i] == nums[i - 1] && a[i - 1] == 0) {
                continue;
            }
            tmp.add(nums[i]);
            a[i] = 1;
            f(nums, i + 1);
            a[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }


    public int minimumTimeRequired(int[] jobs, int k) {
        int sum = Arrays.stream(jobs).sum();
        int max = Arrays.stream(jobs).max().getAsInt();
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        a = new int[jobs.length];
        Arrays.sort(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        while (max < sum) {
            int mid = (sum + max) >> 1;
            int cnt = 0;
            int slice = 1;
            for (int i = 0; i < jobs.length; i++) {
                if (cnt + jobs[i] > mid) {
                    slice++;
                    cnt = 0;
                }
                cnt += jobs[i];
            }
            if (slice > k)
                max = mid + 1;
            else
                sum = mid;

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new miniumTimeRequired().minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
//        new miniumTimeRequired().f(new int[]{1,2,4,7,8},0);

    }

}
