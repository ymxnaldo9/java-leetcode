package linklist._0025;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++){
            if (b == null)
                return head;
            b = b.next;
        }
        ListNode newhead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newhead;
    }
    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode temp;
        while (cur != b){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}