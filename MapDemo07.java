import java.util.ArrayList;
import java.util.HashMap;

public class MapDemo07 {
    public static void main(String[] args) {
        String S = "babbBba";
        String T = "Abbb";
        String res = minWindow(S, T);
        System.out.println("结果：" + res);
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map_s = new HashMap<>();  //窗口中字符数量映射
        HashMap<Character, Integer> map_t = new HashMap<>();  //子串字符数量映射
        ArrayList<Character> vec_t = new ArrayList<>();  //记录窗口中的字符
        if (t.length() > s.length()) {
            return "";
        }
        if (t.length() == 1) {
            if (s.contains(t)) {
                return t;
            } else {
                return "";
            }
        }

        for (int i = 0; i < s.length(); i++) {  //初始化map_s
            map_s.put(s.charAt(i), 0);
        }
        for (int i = 0; i < t.length(); i++) {  //初始化map_t
            map_t.put(t.charAt(i), 0);
        }
        for (int i = 0; i < t.length(); i++) { //更新T中字符数量
            int value = map_t.get(t.charAt(i));
            map_t.put(t.charAt(i), value + 1);
            if (map_t.get(t.charAt(i)) > 0) {
                char c = t.charAt(i);
                vec_t.add(c);
            }
        }
        System.out.println("map_t:" + map_t);
        System.out.println("vec_t:" + vec_t);
        int begin = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int value2 = map_s.get(s.charAt(i));  //i指针指向的字符，数量加一
            map_s.put(s.charAt(i), value2 + 1);
            System.out.println("更新中的map_s:" + map_s);
            while (begin < i) {
                char begin_c = s.charAt(begin);
                if (!map_t.containsKey(begin_c)) {  //T 中没有该字符，begin+1
                    begin++;
                    System.out.println("T 中没有该字符begin++:" + begin_c + "   " + begin);
                } else if (map_s.get(begin_c) > map_t.get(begin_c)) {  //窗口中该字符数量充足，begin+1
                    int value3 = map_s.get(begin_c);
                    map_s.put(begin_c, value3 - 1);
                    begin++;
                    System.out.println("T 中没有该字符begin++:" + begin_c + "   " + begin);
                } else if (map_s.get(begin_c) > map_t.get(begin_c)) {  //窗口中该字符数量充足，begin+1
                    int value3 = map_s.get(begin_c);
                    map_s.put(begin_c, value3 - 1);
                    begin++;
                } else {
                    break;
                }
            }
            if (is_window_ok(map_s, map_t, vec_t)) {
                System.out.println("begin:" + begin + "  i:" + i);
                int new_len = i - begin + 1;
                System.out.println("new_len:" + new_len);
                System.out.println("result: " + result);
                if (result == "" || result.length() > new_len) {
                    result = s.substring(begin, i + 1);
                }
            }
        }
        return result;
    }

    private static boolean is_window_ok(HashMap<Character, Integer> map_s, HashMap<Character, Integer> map_t, ArrayList<Character> vec_t) {
        for (int i = 0; i < vec_t.size(); i++) {

            System.out.println("map_s.containsKey(" + vec_t.get(i) + "): " + i + " " + map_s.containsKey(vec_t.get(i)) + " " + map_s.get(vec_t.get(i)) + " " + map_t.get(vec_t.get(i)) + " " + (map_s.containsKey(vec_t.get(i)) && (map_s.get(vec_t.get(i)) < map_t.get(vec_t.get(i)))));
            if (!map_s.containsKey(vec_t.get(i)))
                return false;
            if (map_s.containsKey(vec_t.get(i)) && (map_s.get(vec_t.get(i)) < map_t.get(vec_t.get(i)))) {
                System.out.println("map_s:" + map_s.get(vec_t.get(i)) + "小于map_t:" + map_t.get(vec_t.get(i)));
                return false;
            }
        }
        return true;
    }
}