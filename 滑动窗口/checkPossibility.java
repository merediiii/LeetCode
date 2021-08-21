package 滑动窗口;

public class checkPossibility {
    public static boolean f(int[] nums) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int max = 0x80000000;
        max = nums[0];

        int mark = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[l]) {
                cnt++;
                if (l == 0) {
                    l++;
                    max = nums[l];
                }
                if (i == nums.length - 1 && cnt == 1) {
                    return true;
                }

                continue;
            }
            System.out.println(nums[i]);
            if (nums[i] < max || cnt > 1)
                return false;
            l = i;
            max = Math.max(max, nums[l]);

        }
        System.out.println(cnt);
        return cnt < 2 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{-1, 4, 2, 3}));
    }
}
