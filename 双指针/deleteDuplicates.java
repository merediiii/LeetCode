package 双指针;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class deleteDuplicates {
    public ListNode f(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        if (p.next == null) return p;
        while (p != null) {
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;

        }
        return head;
    }

}
