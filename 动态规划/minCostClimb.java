package 动态规划;

import java.util.Arrays;

/*
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

示例 1:

输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 示例 2:

输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
注意：

cost 的长度将会在 [2, 1000]。
每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。


暴力递归
class Solution {
    private static int[] r;

    public int minCostClimbingStairs(int[] cost) {
        return f(cost.length, cost);
    }

    public int f(int i,int[] n){
        if(i<=1) return 0;
        return Math.min(f(i - 1,n) + n[i-1] , f(i-2,n) +n[i-2]);
    }
}

 */
public class minCostClimb {
    private static int[] r;

    public static int f1(int[] cost) {
        r = new int[cost.length+1];
        Arrays.fill(r,-1);
        return f(cost.length,cost);
    }

    public static int f(int i,int[] n){
        if(i==0|| i ==1) return 0;
        if(r[i] >= 0) return r[i];
        r[i] = Math.min(f(i-1,n)+n[i-1],f(i-2,n)+n[i-2]);//记忆化搜索,自顶向下
        return r[i];
    }


    //以下两个都是用的自底向上的递推
    public static int f2(int[] cost){
        r = new int[cost.length+1];
        r[0] = 0;
        r[1] = 0;
        for (int i = 2; i <= cost.length; i++)
            r[i] = Math.min(cost[i-2] + r[i-2],cost[i-1]+r[i-1]);   //不同于f3(),r[i]记录的是到达第i阶的代价,故由于到第i阶台阶,有从第i-2阶和第i-1阶过来这两种,
                                                                    //因此,r[i-2]+cost[i-2]就是到达第i-2阶台阶再加上cost[i-2]离开第i-2阶到达第i阶的代价,
                                                                    //同理cost[i-1]+r[i-1]是....i-1......i-1......到达第i阶的代价,取二者中的小者即可
        return r[cost.length];
    }

    public static int f3(int[] cost) {
        int len = cost.length;
        for(int i=2;i<len;i++){
            cost[i] = Math.min(cost[i-1]+cost[i],cost[i]+cost[i-2]);//这个计算的是离开第i阶台阶的代价,就是用cost数组来避免新开一个,比如上面f2()中的r[]
        }
        return Math.min(cost[len-1],cost[len-2]);   //因为到第i阶台阶,有从第i-2阶和第i-1阶过来这两种,
                                                    //故由于cost[i]已经代表的是离开第i阶台阶的代价,
                                                    //所以只需要取cost[i-1]和cost[i-2]之间的小者就可以了,即从第i-2阶离开到第i阶或第i阶离开到第i阶
    }

    //造成f2()和f3()的递推形式不同的主要原因是,f2()中新开辟的r[i]记录的是到达第i阶的代价(不计算cost[i])
    //                                    ,而f3()中用cost[i]计算的是离开第i阶台阶的代价(计算cost[i])

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 32, 13, 34, 72, 45, 37, 44, 1, 63, 62, 9, 73, 5, 4, 2, 1};
        System.out.println(f1(test));
        System.out.println(f2(test));
        System.out.println(f3(test));
    }
}
