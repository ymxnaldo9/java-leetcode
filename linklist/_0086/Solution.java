package linklist._0086;

public class Solution {
    public static void main(String... args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);
        Solution s = new Solution();
        ListNode p = s.partition(l, 3);
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);
        ListNode p = head;
        ListNode l1 = low;
        ListNode l2 = high;
        while (p != null){
            if (p.val < x){
                l1.next = p;
                l1 = l1.next;
            }
            else{
                l2.next = p;
                l2 = l2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        l1.next = high.next;
        return low.next;
    }
}
class ListNode {
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