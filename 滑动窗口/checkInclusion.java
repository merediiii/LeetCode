package 滑动窗口;

import java.util.Arrays;

public class checkInclusion {

    // 458ms
    public static boolean f(String s1, String s2) {
        int l1 = s1.length();
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        for (int i = 0; i < l1; i++) {
            ch1[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (ch1[s2.charAt(i) - 'a'] == 0) {
                l = i + 1;
                Arrays.fill(ch2, 0);
                continue;
            }
            ch2[s2.charAt(i) - 'a']++;
            if (ch2[s2.charAt(i) - 'a'] > ch1[s2.charAt(i) - 'a']) {
                Arrays.fill(ch2, 0);
                i = l;
                l++;
            }
            if (i - l + 1 == l1) {
                return true;
            }

        }
        return false;
    }


    // 6ms
    public static boolean g(String s1, String s2) {
        int l1 = s1.length();
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        for (int i = 0; i < l1; i++) {
            ch1[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = l1 - 1 - l;
        boolean isBoolean = true;
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < l1; i++) {
            if (ch1[s2.charAt(i) - 'a'] == 0) {
                isBoolean = false;
            }
            ch2[s2.charAt(i) - 'a']++;
            if (ch2[s2.charAt(i) - 'a'] > ch1[s2.charAt(i) - 'a'])
                isBoolean = false;
        }
        if (isBoolean) return isBoolean;
        int k = 0;
        while (r < s2.length() - 1) {
            k = 0;
            ch2[s2.charAt(l++) - 'a']--;
            ch2[s2.charAt(++r) - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (ch1[i] != ch2[i]) {
                    k = 1;
                    break;
                }
            }
            if (k == 0) return true;

        }
        return isBoolean;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(g(s1, s2));

    }
}
