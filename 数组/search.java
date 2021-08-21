package 数组;

public class search {


    public static int bst(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;
        int mid = (l + r) >> 1;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < nums[r] && target > nums[mid] && target <= nums[r])
            return bst(nums, mid + 1, r, target);
        else if (nums[mid] < nums[r] && (target < nums[mid] || target >= nums[l]))
            return bst(nums, l, mid - 1, target);
        else if (nums[l] < nums[mid] && target >= nums[l] && target < nums[mid])
            return bst(nums, l, mid - 1, target);
        else
            return bst(nums, mid + 1, r, target);

    }

    public static int f(int[] nums, int target) {
        return bst(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(f(nums, 3));
    }
}
