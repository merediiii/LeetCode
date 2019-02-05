package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
 */
public class postorderTraversal {

    public List<Integer> list = new ArrayList<>();

    public List<Integer> f(TreeNode root) {
        if (root == null) return list;
        f(root.left);
        f(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> g(TreeNode root) {
        if (root == null) return list;
        Stack<TreeNode> a = new Stack<>();
        Stack<TreeNode> b = new Stack<>();
        TreeNode node = root;
        a.push(node);
        while (!a.isEmpty()) {
            node = a.pop();
            b.push(node);
            if (node.left != null)
                a.push(node.left);
            if (node.right != null)
                a.push(node.right);
        }
        while (!b.isEmpty())
            list.add(b.pop().val);
        return list;
    }

    public List<Integer> h(TreeNode root) {
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            while (stack.peek().left!=null){
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()){
                if(node==stack.peek().right||stack.peek().right==null)
                    list.add((node = stack.pop()).val);
                else if(stack.peek().right!=null) {
                    stack.push(stack.peek().right);
                    break;
                }
            }
        }
        return list;
    }

    public List<Integer> i(TreeNode root) {
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        return list;
    }
}

