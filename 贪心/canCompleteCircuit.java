package 贪心;

import java.util.ArrayList;
import java.util.Arrays;

/*
134. 加油站
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明:

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:

输入:
gas  = [2,3,4]
cost = [3,4,3]

输出: -1

解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class canCompleteCircuit {
    public static int f(int[] gas, int[] cost) {
        int len = gas.length;
        int[] start = new int[len];
        int max = 0;
        int min = 0x7fffffff;
        int min_i = 0;
        int min_cost = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (gas[i] >= cost[i]) {
                list.add(i);
                start[i] = gas[i] - cost[i];
                if (start[i] >= max) {
                    max = start[i];
                    if (gas[i] < min) {
                        min_i = i;
                        min = gas[i];
                        min_cost = cost[i];
                    }
                    if (gas[i] == min)
                        if (cost[i] < min_cost) {
                            min_i = i;
                            min = gas[i];
                            min_cost = cost[i];
                        }
                } else if (start[i] == max) {
                    if (cost[i] < min_cost) {
                        min_i = i;
                        min = gas[i];
                        min_cost = cost[i];
                    }
                }
            }
        }
        System.out.println("min: " + min_i);
        int i = 0;
        int remain = 0;
        int success = -1;
        int j = 0, t = 0;
        int i_length = 0;
        for (i = min_i; i_length < len; i++) {
            t = 0;
            remain = 0;
            for (j = i % len; remain >= 0 && (t == 0 || (j % len != i && t > 0)); j++) {
                if (remain + gas[j % len] >= cost[j % len])
                    remain += gas[j % len] - cost[j % len];
                else
                    break;
                t++;
                if (remain >= 0 && (j + 1) % len == i % len)
                    return i % len;

            }
            i_length++;
        }
        return success;
    }

    public static void main(String[] args) {
        int[] p = {6, 1, 4, 3, 5};
        int[] q = {3, 8, 2, 4, 2};
        System.out.println(f(p, q));
    }
}
