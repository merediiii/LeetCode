package 搜索;

public class test {
    public int f(int[] nums, int n) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(nums, mid, n)) {
                r = mid;
            } else
                l = mid + 1;
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int n) {
        for (int i = 0; i < nums.length; i++) {

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new test().f(new int[]{0, 1, 2, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 10}, 6));
    }
}
