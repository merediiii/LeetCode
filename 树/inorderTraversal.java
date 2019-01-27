package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
 */
public class inorderTraversal {
    public List<Integer> list = new ArrayList<>();

    public List<Integer> f(TreeNode root) {
        if (root == null) return list;
        f(root.left);
        list.add(root.val);
        f(root.right);
        return list;
    }

    public List<Integer> g(TreeNode root) {
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
