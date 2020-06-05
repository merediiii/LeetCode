package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class minimumTotal {

    public static int max = Integer.MAX_VALUE;
    public static int[] dp;


    public static int f(List<List<Integer>> triangle) {
        int size = triangle.size();
        int res = max;
        dp = new int[size];
        Arrays.fill(dp,max);
        dp[0] = triangle.get(0).get(0);
        for(int i = 1 ; i < size ; i++ ){
            for(int j = i ; j >= 0 ; j--){
                dp[j] = Math.min((j-1)<0?max:dp[j - 1],dp[j]) + triangle.get(i).get(j);
            }
        }
        for(int i = 0 ; i < size ; i++){
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        list.add(a);
        a.clear();
        a.add(3);
        a.add(4);
        list.add(a);
        a.clear();
        a.add(6);
        a.add(5);
        a.add(7);
        list.add(a);
        a.clear();
        a.add(4);
        a.add(1);
        a.add(8);
        a.add(3);
        list.add(a);
        a.clear();
        System.out.println(f(list));
    }
}
