package linklist.offer22;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
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
}
