package 数组;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public static List<Integer> f(int[][] matrix) {
        int i = 0;
        int j = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        while (res.size() != matrix.length * matrix[0].length) {
            while (visited[i][j] == false && j < matrix[0].length) {
                if (visited[i][j] == false) {
                    visited[i][j] = true;
                    res.add(matrix[i][j++]);
                }


            }
            if (j == matrix[0].length) {
                j--;
                while (visited[i][j] == false && i < matrix.length) {

                    if (visited[i][j] == false) {
                        visited[i][j] = true;
                        res.add(matrix[i++][j]);
                    }

                }
            }
            if (i == matrix.length) {
                i--;
                while (visited[i][j] == false && j >= 0) {

                    if (visited[i][j] == false) {
                        visited[i][j] = true;
                        res.add(matrix[i][j--]);
                    }

                }
            }
            while (visited[i][j] == false) {

                if (visited[i][j] == false) {
                    visited[i][j] = true;
                    res.add(matrix[i][j++]);
                }
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[4][3];
        mat = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(f(mat));
    }
}
