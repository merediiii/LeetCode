package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxPrime {

    private static Scanner sc = new Scanner(System.in);

    public static List<Integer> list = new ArrayList<>();

    public static int num(int n, int[] size) {
        if (n <= 3) {
            return size[n];
        }
        for (int i = 4; i <= n; i++) {
            if (i % 2 == 0)
                size[i] = i / 2;
            else
                size[i] = 1 + size[i - 3];
        }
        return size[n];
    }

    public static void main(String[] args) {
        int num = sc.nextInt();
        int[] data = new int[num];
        int sum = 0;
        int size = 0;
        int mark = 0;

        for (int i = 0; i < num; i++) {
            data[i] = sc.nextInt();
            if (data[i] > size) {
                mark = i;
            }
            size = Math.max(size, data[i]);

        }
        int[] dp = new int[size + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        num(data[mark], dp);
        for (int i = 0; i < num; i++) {
            sum += dp[data[i]];
        }
        System.out.println(sum);


    }
}
