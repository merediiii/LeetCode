import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        int[][] map = new int[][]{{1, 1, 1,}, {1, 1, 0}, {1, 0, 1}};
        map = new Main().floodFill(map, 1, 1, 2);
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        int[] b = new int[26];
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 97]++;
//            b[s2.charAt(i)-97]++;
        }
        int l = 0;
        int r = s1.length() - 1;
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) flag = false;
        }
        for (int i = 0; i <= r; i++) {
            b[s2.charAt(i) - 'a']++;
        }
        if (flag) return true;
        while (r < s2.length()) {
            flag = true;
            if (1 + r == s2.length())
                break;
            b[s2.charAt(l++) - 'a']--;
            b[s2.charAt(++r) - 'a']++;

            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }


        return false;
    }

    public int compress(char[] chars) {
        int[] map = new int[26];
        int pre = 0;
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
//            System.out.println(chars[i] + "\t" + (chars[i+1]));
            if (chars[i] - 'a' >= 0 && map[chars[i] - 'a'] == 0 && flag == 0)
                pre = i + 1;
            if (chars[i] - 'a' >= 0) {
                if (chars[i] - 'a' < 0)
                    map[chars[i - 1] - 'a']++;
                else
                    map[chars[i] - 'a']++;
                if (i < chars.length - 1) {
                    if (map[chars[i] - 'a'] == 1 && chars[i] != chars[i + 1])
                        continue;
                    else {
                        System.out.println("map[chars[i] - 'a']\t" + map[chars[i] - 'a']);
                        if (map[chars[i] - 'a'] < 10) {
//                        chars[pre] = (char) (map[chars[i] - 'a'] + '0');
                            System.out.println("chars1\t" + chars[pre]);
                        } else {
                            map[chars[i] - 'a'] -= 10;
                            flag++;
                            pre++;

                            System.out.println("chars2\t" + chars[pre]);
                        }
                        if (chars[i] != chars[i + 1])
                            flag = 0;
                        chars[pre] = (char) (map[chars[i] - 'a'] + '0');

                    }
                }
            }
        }
        return pre + 1;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int tar = image[sr][sc];
        dfs(image, sr, sc, newColor, tar);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int tar) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length) {
            System.out.println(sr + "\t" + sc + "\t" + image[sr][sc]);
        }
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != tar) {

            return;
        }

        if (image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, tar);
        dfs(image, sr - 1, sc, newColor, tar);
        dfs(image, sr, sc + 1, newColor, tar);
        dfs(image, sr - 1, sc, newColor, tar);
    }


}