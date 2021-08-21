package 深度优先;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class countPairs {
    List<List<Integer>> list;
    List<Integer> tmp;

    public int countPairs(int[] deliciousness) {
        return f(deliciousness);
    }

    private int f(int[] deliciousness) {
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(deliciousness, 0);
        return list.size() % 1000000007;
    }

    private void dfs(int[] deliciousness, int index) {
        if (tmp.size() == 2) {
            long sum = 0;
            for (int i = 0; i < tmp.size(); i++) {
                sum += tmp.get(i);
            }
            if ((sum & (sum - 1)) == 0) {

                list.add(new ArrayList<>(tmp));
                return;
            } else
                return;
        }
        for (int i = index; i < deliciousness.length; i++) {
            tmp.add(deliciousness[i]);
            dfs(deliciousness, i + 1);
            tmp.remove(tmp.size() - 1);

        }
    }

    public int g(int[] deliciousness) {
        HashMap<Long, Integer> dic = new HashMap<>();
        Arrays.sort(deliciousness);
        int result = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j < 21; j++) {
                long k = (long) Math.pow(2, j) - deliciousness[i];
                if (!dic.containsKey(k))
                    dic.put(k, deliciousness[i]);
                else
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new countPairs().g(new int[]{1, 3, 5, 7, 9}));
    }
}
