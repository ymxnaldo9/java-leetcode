package linklist._0019;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode x = getKthFromEnd(pre, n + 1);
        x.next = x.next.next;
        return pre.next;
    }
    private ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++){
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}