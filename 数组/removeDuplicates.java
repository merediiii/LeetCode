package 数组;

public class removeDuplicates {
    public static int f(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int len = f(nums);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
