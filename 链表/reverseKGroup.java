package 链表;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseKGroup {
    public static ListNode f(ListNode head, int k) {
        ListNode p = head, q = head;
        ListNode[] stack = new ListNode[k];
        int top = 0, syb = 0;
        int mark = 0;
        while (p != null) {
            stack[top++] = p;
            syb++;
            if (syb < k && p.next == null)
                q.next = stack[0];
            p = p.next;
            if (top == k) {
                if (mark++ == 0) {
                    head = stack[--top];
                    q = head;
                }
                while (top > 0) {
                    ListNode node = stack[--top];
                    q.next = node;
                    q = node;
                }
                syb = 0;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = null;
        ListNode head = list1;
        ListNode headed = f(list1, 2);

        while (headed != null) {
            System.out.print(headed.val + "->");
            headed = headed.next;
        }
        System.out.println("null");
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
