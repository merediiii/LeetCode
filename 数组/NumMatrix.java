package 数组;

public class NumMatrix {

    public int[][] res;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length + 1;
        if (row == 1)
            return;
        int col = matrix[0].length + 1;
        res = new int[row][col];
        int j = 0;
        for (int i = 1; i < row; i++) {
            for (j = 1; j < col; j++) {
                res[i][j] += matrix[i - 1][j - 1] + res[i][j - 1] + res[i - 1][j] - res[i - 1][j - 1];
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return res[row2 + 1][col2 + 1] - res[row2 + 1][col1] - res[row1][col2 + 1] + res[row1][col1];
    }

//    public NumMatrix(int[][] matrix) {
//        int row = matrix.length;
//        if(row == 0)
//            return;
//        int col = matrix[0].length + 1;
//        res = new int[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 1; j < col; j++) {
//                res[i][j] = matrix[i][j - 1] + res[i][j - 1];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int sum = 0;
//        for (int i = row1; i <= row2 ; i++) {
//            sum += res[i][col2+1] - res[i][col1];
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(13));
    }
}
