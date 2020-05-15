package 字符串;

import java.sql.Array;
import java.util.*;

public class groupAnagrams {
    public static List<List<String>> f(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[][] p = new int[strs.length][26];
        for (int i = 0; i < strs.length; i++) {
            char[] dic = strs[i].toCharArray();
            for (int j = 0; j < dic.length; j++) {
                p[i][strs[i].charAt(j)-97] += 1;
            }
        }
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        int j = 0;

        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0;k < p[i].length; k++){
                sb.append(p[i][k]);
            }
            if (!map.containsValue(sb)) {
                map.put(j++, sb);
            }
        }
        for (StringBuilder v : map.values()) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                StringBuilder t = new StringBuilder();
                for (int k = 0;k < p[i].length; k++){
                    t.append(p[i][k]);
                }
                if(t.toString().equals(v.toString()))
                    tmp.add(strs[i]);

            }
            if (res.contains(tmp))
                continue;
            res.add(tmp);
        }
        return res;
    }

    public static List<List<String>> g(String[] strs){
        List<List<String>> res = new ArrayList<>();


        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0 ;i < strs.length;i++){

            List<String> tmp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            char[] t = strs[i].toCharArray();
            Arrays.sort(t);
            String key = Arrays.toString(t);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            }
            else {
                tmp.add(strs[i]);
                map.put(key, tmp);
            }

        }
        for(List<String> s:map.values())
            res.add(s);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(g(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
