package 哈希表;

import java.util.*;
import java.util.stream.Collectors;

public class topKFrequent {
    public List<String> f(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], 1);
            else
                map.put(words[i], map.get(words[i]) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0)
                    return o1.getKey().compareTo(o2.getKey());
                else
                    return o2.getValue().compareTo(o1.getValue());
            }

        });

        int flag = 0;
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> l : list) {
            if (flag++ < k)
                ans.add(l.getKey());
            System.out.println(l.getKey());
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new topKFrequent().f(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
