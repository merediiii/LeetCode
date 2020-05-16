package 哈希表;

import java.util.*;

public class findRepeatedDnaSequences {
    public static List<String> f(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] tmp = new char[10];
        for (int i = 0; i < chars.length - 9; i++) {
            for (int j = 0; j < 10; j++) {
                tmp[j] = chars[i + j];
            }
            String string = String.valueOf(tmp);
            System.out.println(string);
            if (!map.containsKey(string))
                map.put(string + "", 1);
            else
                map.put(string + "", map.get(string) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        }
        return list;
    }
    public static List<String> g(String s) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String string = s.substring(i,i+10);
            if (!map.containsKey(string))
                map.put(string, 1);
            else
                map.put(string, map.get(string) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                list.add(entry.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(f("AAAAAAAAAAA"));
    }
}
