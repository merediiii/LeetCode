package 搜索;

import java.util.ArrayList;
import java.util.List;


/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class permute {
    public static List<List<Integer>> ans = new ArrayList<>();

    public static int[] tmp = new int[100];

    public static boolean[] bool = new boolean[100];

    public static void g(int i, int[] nums){
        if(i >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                temp.add(nums[tmp[j]]);
            }
            ans.add(temp);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(bool[j] == false) {
                tmp[i] = j;
                bool[j] = true;
                g(i + 1, nums);
                bool[j] = false;
            }
        }
    }

    public static List<List<Integer>> f(int[] nums) {
        ans.clear();
        g(0,nums);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(f(new int[]{1,2,3}));
    }
}
