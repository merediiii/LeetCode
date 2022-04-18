package 牛客;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

/*
链接：https://ac.nowcoder.com/acm/contest/5600/A
来源：牛客网
 */
public class Nowcoder_001 {

    public static Scanner sc = new Scanner(System.in);


    public static long f(int[] monster, int mp2) {
        long a = 0, b = 0;
        for (int i = 0; i < monster.length; i++) {
            b += monster[i];
        }
        if (mp2 > monster.length)
            return b;
        for (int i = monster.length - 1; mp2 > 0; i--, mp2--) {
            a += monster[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int len, n;
        len = sc.nextInt();
        n = sc.nextInt();
        int[] monster = new int[len];
        for (int i = 0; i < len; i++) {
            monster[i] = sc.nextInt();
        }
        Arrays.sort(monster);
        System.out.println(f(monster, n));
    }
}
