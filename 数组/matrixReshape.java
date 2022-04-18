package 数组;

public class matrixReshape {
    public static int[][] f(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c)
            return nums;
        int[][] res = new int[r][c];
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.println(y / c + "\t" + y % c + "\t" + nums[i][j]);
                res[y / c][(y) % c] = nums[i][j];
                y++;
            }
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[][]{{1, 2}, {3, 4}}, 1, 4));
    }
}
