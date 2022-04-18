package 并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class unn {

    public static int ele;
    public static int[] weight;
    public static int[] union;

    public static void init(int n) {
        ele = n;
        union = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
            weight[i] = 1;
        }
    }

    public static int find(int x) {
        return x == union[x] ? x : (union[x] = find(union[x]));
    }

    static void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x == y)
            return;
        if (weight[x] <= weight[y])
            union[x] = y;
        else
            union[y] = x;
        if (weight[x] == weight[y] && x != y)
            weight[y]++;
    }

    static boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public static List<Integer> f(int[][] num) {
        init(num.length);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                if (j >= 1)
                    if (num[i][j] != 0 && i != j)
                        merge(i, j);
            }
        }
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (!group.contains(find(i))) {
                group.add(i);
            }
        }
        return group;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int[] nums = new int[2];
            nums[0] = in.nextInt();
            nums[1] = in.nextInt();
            int[][] city = new int[nums[0]][nums[0]];
            for (int i = 0; i < city.length; i++) {
                Arrays.fill(city[i], 1);

            }
            for (int i = 0; i < nums[1]; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                city[a - 1][b - 1] = 0;
            }
            List<Integer> list = f(city);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}
