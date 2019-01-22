package 树;
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

注意对比求树的深度:
    public int f(TreeNode root) {
        if(root == null) return 0;
        int left = f(root.left);
        int right = f(root.right);
        return 1+Math.max(left,right);
    }

因为实际上最小深度和高度(最大深度)的区别就是 自下向上递归的过程中取大还是取小

 */
public class minDepth {
    public int f(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null)      //注意当左子树或者右子树为空的时候,要另外处理
            return f(root.right) + 1;   //因为对于最大深度而言,取最大的就可以了,但是如果是求最小的话,如果子树为空的话不能直接取最小的,
        else if(root.right == null)     //因为计算最小深度首先得要有叶子才能开始计算
            return f(root.left) + 1;    //递归的时候记得要对各种情况,边界条件做处理
        else return Math.min(f(root.left),f(root.right)) + 1;
    }
}
