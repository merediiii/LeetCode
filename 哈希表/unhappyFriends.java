package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class unhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> clos = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][0], pairs[i][1]);
            map.put(pairs[i][1], pairs[i][0]);
        }
        int res = 0;
        for (int i = 0; i < preferences.length; i++) {
            int comp = map.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < preferences[i].length && preferences[i][j] != comp; j++) {
                tmp.add(preferences[i][j]);
            }
            boolean flag = false;
            if (tmp.size() != 0) {
                for (int j = 0; j < tmp.size(); j++) {
                    int[] t = preferences[tmp.get(i)];

                    for (int k = 0; k < t.length && t[k] != map.get(tmp.get(i)); k++) {
                        if (t[k] == i) {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag) res++;


        }

        return res;
    }
}
