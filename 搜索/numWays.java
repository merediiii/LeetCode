package 搜索;

import java.util.ArrayList;
import java.util.List;

public class numWays {

    public List<List<String>> list;
    public List<String> tmp;

    public int f(int n, int[][] relation, int k) {
        tmp = new ArrayList<>();
        list = new ArrayList<>();
        dfs(n, relation, k, relation.length);
        System.out.println(list);
        return list.size();
    }

    private void dfs(int n, int[][] relation, int k, int index) {
        if (tmp.size() == k && Integer.valueOf(tmp.get(0).split("->")[0]) == 0 && Integer.valueOf(tmp.get(tmp.size() - 1).split("->")[1]) == n - 1) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        if (tmp.size() == k) {
            return;
        }
        for (int i = 0; i < relation.length; i++) {
            if (i == index)
                continue;
            if (tmp.size() > 0) {
                String t1 = tmp.get(tmp.size() - 1).split("->")[1];
                String t0 = tmp.get(tmp.size() - 1).split("->")[0];
                if (Integer.valueOf(t1) == relation[i][0]) {
                    tmp.add(relation[i][0] + "->" + relation[i][1]);
                    dfs(n, relation, k, i);
                    tmp.remove(tmp.size() - 1);
                }
            } else {
                tmp.add(relation[i][0] + "->" + relation[i][1]);
                dfs(n, relation, k, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] relations = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int[][] relation = {{0, 2}, {0, 1}, {1, 2}, {2, 1}, {2, 0}, {1, 0}};
        int k = 3;
        System.out.println(new numWays().f(n, relations, k));
    }
}
