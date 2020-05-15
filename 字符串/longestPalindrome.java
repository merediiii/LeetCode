package 字符串;

import java.util.HashMap;

public class longestPalindrome {
    public static int f(String s) {
        int[] dic = new int[128];
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            dic[a[i]]++;
        }
        int max_odd = 0, sum = 0 , odd = 0;
        for (int i = 0; i < 128; i++)
            if ((dic[i] & 1) == 1) {
                max_odd = Math.max(max_odd, dic[i]);
                odd++;
            }
        for (int i = 0; i < 128; i++) {
            if ((dic[i] & 1) == 1)
                sum += dic[i] - 1;
            else
                sum += dic[i];
        }

        return sum + odd > 0?1:0;

    }

    public static void main(String[] args) {
        System.out.println((int)'Z');
        System.out.println(f("dd"));
    }
}
