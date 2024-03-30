package 搜索.dfs;

public class minimumAddedCoins_2952 {


	/*
	2952.需要添加的硬币的最小数量

		给你一个下标从0开始的整数数组coins，表示可用的硬币的面值，以及一个整数target。
	如果存在某个coins的子序列总和为x，那么整数x就是一个可取得的金额。
	返回需要添加到数组中的任意面值硬币的最小数量，使范围[1,target]内的每个整数都属于可取得的金额。
	数组的子序列是通过删除原始数组的一些（可能不删除）元素而形成的新的非空数组，删除过程不会改变剩余元素的相对位置。



	示例1：

	输入：coins=[1,4,10],target=19
	输出：2
	解释：需要添加面值为2和8的硬币各一枚，得到硬币数组[1,2,4,8,10]。
	可以证明从1到19的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为2。
	示例2：

	输入：coins=[1,4,10,5,7,19],target=19
	输出：1
	解释：只需要添加一枚面值为2的硬币，得到硬币数组[1,2,4,5,7,10,19]。
	可以证明从1到19的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为1。
	示例3：

	输入：coins=[1,1,1],target=20
	输出：3
	解释：
	需要添加面值为4、8和16的硬币各一枚，得到硬币数组[1,1,1,4,8,16]。
	可以证明从1到20的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为3。


	提示：

	1<=target<=105
	1<=coins.length<=105
	1<=coins[i]<=target
	*/

	/**
	 * @param coins
	 * @param target
	 * @return
	 */
	public int minimumAddedCoins(int[] coins, int target) {

	}

	public boolean canAdd(int[] coins,int target){

	}

	public static void main(String[] args) {
		assert new minimumAddedCoins_2952().minimumAddedCoins(new int[]{1, 4, 10, 5, 7, 19}, 19) == 1;
	}
}
