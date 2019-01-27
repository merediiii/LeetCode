package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
589. N叉树的前序遍历
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

                        1
                    /   |   \
                   3    2    4
                  / \
                 5   6

返回其前序遍历: [1,3,5,6,2,4]。
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class preorder {

    public static List<Integer> list = new ArrayList<>();

    public List<Integer> f(Node root) {
        if(root == null) return list;
        list.add(root.val);
        for (Node node:root.children)
            f(node);
        return list;
    }

    public List<Integer> g(Node root){
        Stack<Node> s = new Stack<>();
        if(root == null) return list;
        Node node = root;
        s.push(node);
        while (!s.isEmpty()){
            node = s.pop();
            list.add(node.val);
            for(int i = node.children.size()-1;i >= 0;i--)
                s.add(node.children.get(i));
        }
        return list;
    }
}
