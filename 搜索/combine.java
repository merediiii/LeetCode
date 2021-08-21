package 搜索;

import 字符串.myAtoi;

import java.util.ArrayList;
import java.util.List;

public class combine {

    List<List<Integer>> list;
    List<Integer> tmp;

    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        dfs(n, k, 1);
        return list;
    }

    public void dfs(int n, int k, int index) {
        if (k - tmp.size() > n - index + 1)
            return;
        if (tmp.size() == k) {
            list.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i <= n; i++) {
            tmp.add(i);
            dfs(n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new combine().combine(4, 2));
    }
}
