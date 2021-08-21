package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePaths {

    public List<String> list;

    public List<String> f(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        list = new ArrayList<>();
        if (root == null)
            return list;
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode tmp = stk.pop();

            if (stk.peek().left != null) {
                stk.push(stk.peek().left);
                continue;
            }
            if (stk.peek().right != null) {
                stk.push(stk.peek().right);
                continue;
            }

        }
        return list;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
    }

}
