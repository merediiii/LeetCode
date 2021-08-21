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

    public static int mp1 = 1;

//    public static int f(int[] monster, int mp2) {
//        int count_max = 0x80000000, count_min = 0x7fffffff, sum = 0;
//        int[] tmp = new int[monster.length];
//        for (int i = 0; i < monster.length; i++) {
//            count_max = Math.max(monster[i], count_max);
//            count_min = Math.min(monster[i], count_min);
//            sum += monster[i];
//            if (monster[i] == monster[i - 1])
//                tmp[i] = tmp[i - 1];
//            else
//                tmp[i] = monster.length - i;
//        }
//        int[] height = new int[count_max];
//        for (int i = 0; i < monster.length; i++) {
//            height[monster[i]] = 1;
//        }
//        int[] hi = new int[count_max];
//        for (int i = count_max - 1; i >= 0; i--) {
//            if (height[i] > 0)
//                hi[i] = tmp[i];
//            else
//                hi[]
//
//        }
//        int min_mp = Math.min(count_max * mp2, sum);
//        int count = 0, level = 0;
//        for (int i = 0; i < count_max; i++) {
//            System.out.println(count + " " + mp1 * (monster.length - i));
//            count += Math.min(mp2, mp1 * (monster.length - i));
//            level++;
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        int len, n;
        len = sc.nextInt();
        n = sc.nextInt();
        int[] monster = new int[len];
        for (int i = 0; i < len; i++) {
            monster[i] = sc.nextInt();
        }
        Arrays.sort(monster);
//        System.out.println(f(monster, n));
    }
}
