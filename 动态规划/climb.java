package 动态规划;

import java.util.Arrays;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

斐波那契数列
*/
public class climb {
    public static int[] r;

    public int climbStairs1(int n) {
        r = new int[n+1];
        r[0] = 1;r[1] = 1;
        for(int i = 2 ; i <= n ; i++)
            r[i] = r[i - 1] + r[i - 2];//自底向上
        return r[n];
    }

    public int climbStairs2(int n) {
        r = new int[n+1];
        Arrays.fill(r,-1);
        return f(n);
    }

    public int f(int n){
        if(n == 0 || n == 1) return 1;
        if(r[n] != -1) return r[n];
        r[n] = f(n-1) + f(n-2);//记忆化搜索
        return r[n];
    }
}
