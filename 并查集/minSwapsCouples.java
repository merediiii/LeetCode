package 并查集;

import java.util.ArrayList;

public class minSwapsCouples {
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

    public static int f(int[] row) {
        ArrayList<Integer> d = new ArrayList<>();
        n = 60;
        init(n);
        for (int i = 0; i < row.length; i += 2) {
            merge(i, i + 1);
        }
        for (int i = 0; i < row.length; i += 2) {
            merge(row[i], row[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            System.out.println(d.contains(find(i)) + "\t" + find(i));
            if (!d.contains(find(i))) {
                count++;
                d.add(find(i));
            }
        }

        System.out.println(row.length / 2 + " " + count);
        return row.length / 2 - count;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{3, 2, 0, 1}));
    }
}
