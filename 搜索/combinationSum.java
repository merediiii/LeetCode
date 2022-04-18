package 搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    List<List<Integer>> list;
    List<Integer> tmp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return list;
    }

    public void dfs(int[] n, int target, int index, int sum) {
        if (sum >= target) {
            if (sum == target) {
                list.add(new ArrayList<>(tmp));
                return;
            } else
                return;
        }

        for (int i = index; i < n.length && sum + n[i] <= target; i++) {
            sum += n[i];
            tmp.add(n[i]);
            dfs(n, target, i, sum);
            sum -= n[i];
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new combinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
