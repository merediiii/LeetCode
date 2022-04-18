package 字符串;

import java.util.HashMap;

public class findTheLongestSubstring {
    public static int f(String s) {
        char[] dic = s.toCharArray();
        char[] fu = new char[26];
        int max = 0;
//        for (int i = 0; i < fu.length; i++) {
//            if(dic[i] != 'a' && dic[i] != 'e' && dic[i] != 'i' && dic[i] != 'o' && dic[i] != 'u')
//                fu[dic[i] - 97]++;
//        }
        int[] loc = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dic[i] != 'a' || dic[i] != 'e' || dic[i] != 'i' || dic[i] != 'o' || dic[i] != 'u')
                loc[i] = 1;
        }
        for (int i = 0; i < dic.length; i++) {
            for (int j = i + 1; j <= dic.length; j++) {
                String tmp = s.substring(i, j);
                if (g(tmp))
                    max = max < tmp.length() ? tmp.length() : max;
            }
        }
        return max;
    }

    public static boolean g(String s) {
        int[] mark = {0, 4, 8, 14, 20};
        char[] aeiou = new char[26];
        char[] dic = s.toCharArray();
        for (int i = 0; i < dic.length; i++) {
            aeiou[dic[i] - 97]++;
        }
        for (int i = 0; i < mark.length; i++) {
            if (aeiou[mark[i]] % 2 == 1)
                return false;
        }
        return true;
    }

    public static int h(String s) {
        int len = s.length();
        int[] bit = new int[len + 1];
        bit[0] = 0x00000;
        char[] dic = s.toCharArray();
        for (int i = 0; i < len; i++) {
            switch (dic[i]) {
                case 'a':
                    bit[i + 1] = bit[i] ^ 0x10000;
                    break;
                case 'e':
                    bit[i + 1] = bit[i] ^ 0x01000;
                    break;
                case 'i':
                    bit[i + 1] = bit[i] ^ 0x00100;
                    break;

                case 'o':
                    bit[i + 1] = bit[i] ^ 0x00010;
                    break;
                case 'u':
                    bit[i + 1] = bit[i] ^ 0x00001;
                    break;
                default:
                    bit[i + 1] = bit[i];
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0, first = 0;
        for (int i = 1; i < len + 1; i++) {
            if (!map.containsKey(bit[i]))
                map.put(bit[i], i);
            else
                first = Math.max(first, i - map.get(bit[i]));
        }
        return first;
    }


    public static void main(String[] args) {
        System.out.println(h("eleetminicoworoep"));
    }
}
