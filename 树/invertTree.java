package 树;
/*
226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class invertTree{

    //从上往下交换 即先交换换再递归
    public TreeNode f(TreeNode root) {
        if(root == null) return root;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        root.left = f(root.left);
        root.right = f(root.right);
        return root;
    }

    //从下往上交换 即先递归再交换
    public TreeNode f1(TreeNode root) {
        if(root == null) return root;
        TreeNode left = f1(root.left);
        TreeNode right = f1(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
