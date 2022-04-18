package 哈希表;

import java.util.*;

public class displayTable {
    public List<List<String>> f(List<List<String>> orders) {
        HashMap<String, HashMap<String, String>> table = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (List<String> order : orders) {
            set.add(order.get(2));
            if (!table.containsKey(order.get(1))) {
                HashMap<String, String> tmp = new HashMap<>();
                tmp.put(order.get(2), "1");
                table.put(order.get(1), new HashMap<>(tmp));
            } else {
                HashMap<String, String> tmp = table.get(order.get(1));
                if (!tmp.containsKey(order.get(2)))
                    tmp.put(order.get(2), "1");
                else
                    tmp.put(order.get(2), Integer.valueOf(tmp.get(order.get(2))) + 1 + " ");
                table.put(order.get(1), tmp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> title = new ArrayList<>();

        List<String> so = new ArrayList<>();

        for (String value : set) {

            so.add(value);

        }
        Collections.sort(so);
        title.add("Table");
        for (String s : so) {
            title.add(s);
        }
        res.add(new ArrayList<>(title));

        List<Map.Entry<String, HashMap<String, String>>> list = new ArrayList<>(table.entrySet());

        list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));


        for (Map.Entry<String, HashMap<String, String>> l : list) {
            title.clear();
            title.add(l.getKey());
            for (String s : set) {
                if (!l.getValue().containsKey(s))
                    title.add("0");
                else {
                    title.add(l.getValue().get(s));
                }
            }
            res.add(new ArrayList<>(title));
        }
        return res;
    }
}
