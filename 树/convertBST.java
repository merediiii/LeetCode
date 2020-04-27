package 树;

/*
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
例如：
输入: 原始二叉搜索树:
              5
            /   \
           2     13
输出: 转换为累加树:
             18
            /   \
          20     13
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class convertBST {

    int sum = 0;
    //递归，因为是BST，所以右边>中间>左边,题目的意思是树里面的结点加上截去自身的右边的树的所有结点的和
    //那么先从右边开始算就很方便了,就相当于一个从右孩子开始遍历的先序遍历
    public TreeNode f(TreeNode root) {
        if(root != null){
            f(root.right);
            sum += root.val;
            root.val = sum;
            f(root.left);
        }
        return root;
    }
}
