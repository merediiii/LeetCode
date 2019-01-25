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
    public TreeNode f(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        root.left = f(root.left);
        root.right = f(root.right);
        return root;
    }

    public TreeNode f1(TreeNode root) {
        if(root == null) return root;
        TreeNode left = f1(root.left);
        TreeNode right = f1(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
