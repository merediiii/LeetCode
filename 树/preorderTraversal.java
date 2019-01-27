package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
 */
public class preorderTraversal {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> f(TreeNode root) {
        if(root == null) return list;
        list.add(root.val);
        f(root.left);
        f(root.right);
        return list;
    }

    public List<Integer> g(TreeNode root){
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return list;
    }
}
