package 哈希表;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class romanToInt {
    public int f(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character pre = entry.getKey();
            Character now = entry.getKey();


        }
        return 0;
    }
}
