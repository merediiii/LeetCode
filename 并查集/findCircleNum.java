package 并查集;

import java.util.ArrayList;
import java.util.List;

public class findCircleNum {
    public static int n = 0x7f7f7f7f;
    public static int[] dsu;
    public static int[] rnk;

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

    public static int f(int[][] isConnected) {
        dsu = new int[isConnected.length];
        rnk = new int[isConnected.length];
        n = isConnected.length;
        init(isConnected.length);
        for (int i = 0; i < dsu.length; i++) {
            for (int j = 0; j < dsu.length; j++) {
                if (j >= i && i != j && isConnected[i][j] == 1)
                    merge(i, j);
            }
        }
        List<Integer> d = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!d.contains(find(i))) {
                count++;
                d.add(find(i));
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] tmp = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(f(tmp));
    }
}
