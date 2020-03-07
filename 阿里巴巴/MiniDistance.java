package 阿里巴巴;

/*
概述：
给定一个矩阵，大小为m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置。路径中所有数字累加起来就是路径和，返回所有路径的最小路径和。


示例1
比如输入矩阵为
4 1 5 3
3 2 7 7
6 5 2 8
8 9 4 5


最小路径为
23


 */

import java.util.Arrays;

public class MiniDistance {


    public static int[][] temp;

    public static void f(int[][] n) {
        //temp[0][0]=n[0][0];
        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < temp[0].length; j++) {
                if (i == 0) {
                    temp[i][j] += (j - 1 >= 0 ? temp[i][j - 1] : 0);
                    continue;
                }
                if (j == 0) {
                    temp[i][j] += temp[i - 1][j];
                    continue;
                }
            }
        for (int i = 1; i < temp.length; i++)
            for (int j = 1; j < temp[0].length; j++)
                temp[i][j] += Math.min(temp[i][j - 1], temp[i - 1][j]);
    }

    public static int solution(int[][] m) {
        temp = new int[m.length][m.length];
        for (int i = 0; i < temp.length; i++)
            for (int j = 0; j < temp[0].length; j++)
                temp[i][j] = m[i][j];
        f(m);
        return temp[temp.length - 1][temp[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] mn = {{4, 1, 5, 3}, {3, 2, 7, 7}, {6, 5, 2, 8}, {8, 9, 4, 5}};

        System.out.println(solution(mn));
    }

}
