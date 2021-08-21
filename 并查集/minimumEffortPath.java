package 并查集;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
1631. 最小体力消耗路径
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。

一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。

请你返回从左上角走到右下角的最小 体力消耗值 。



示例 1：
1 2 2
3 8 2
5 3 5

输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
输出：2
解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
示例 2：

1 2 3
3 8 4
5 3 5

输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
输出：1
解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
示例 3：


1 2 1 1 1
1 2 1 2 1
1 2 1 2 1
1 2 1 2 1
1 1 1 2 1

输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
输出：0
解释：上图所示路径不需要消耗任何体力。


提示：

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 */
public class minimumEffortPath {

    public static int n = 0x7f7f7f7f;
    public static int[] dsu = new int[100];
    public static int[] rnk = new int[100];

    public static void init(int n) {
        for (int i = 0; i < n; i++) {
            dsu[i] = i;
            rnk[i] = 1;
        }
    }

    public static int find(int x) {
        return x == dsu[x] ? x : (dsu[x] = find(dsu[x]));
    }

    static void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y)
            return;
        if (rnk[x] <= rnk[y])
            dsu[x] = y;
        else
            dsu[y] = x;
        if (rnk[x] == rnk[y] && x != y)
            rnk[y]++;
    }

    static boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }


    public static int f(int[][] heights) {
        init(heights.length * heights.length);
        int n = (heights.length - 1) * heights.length * 2;
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length; j++) {
                if (i + 1 < heights.length)
                    t.add(new int[]{i * heights.length + j + 1, (i + 1) * heights.length + j + 1, Math.abs(heights[i][j] - heights[i + 1][j])});
                if (j + 1 < heights.length)
                    t.add(new int[]{i * heights.length + j + 1, i * heights.length + j + 2, Math.abs(heights[i][j] - heights[i][j + 1])});
            }
        }
        Collections.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] < o2[2])
                    return -1;
                return 0;
            }
        });

        for (int i = 0; i < t.size(); i++) {
            int len = t.get(i)[2];
            System.out.println("len\t" + len + "\t" + t.get(i)[2]);
            System.out.println(t.get(i)[0] + "\t->\t" + t.get(i)[1]);
            merge(t.get(i)[0], t.get(i)[1]);
            if (isConnected(1, heights.length * heights.length)) {
                return len;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
        System.out.println(f(heights));
    }
}
