package linklist._0023;

public class Solution {
    public static void main(String... args){
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        Solution s = new Solution();
        ListNode l = s.mergeKLists(lists);
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }
    public static ListNode partion(ListNode[] lists, int left, int right){
        if (left == right)
            return lists[left];
        if (left < right){
            int mid = (left + right) / 2;
            ListNode l1 = partion(lists, left, mid);
            ListNode l2 = partion(lists, mid + 1, right);
            return merge(l1, l2);
        }
        else{
            return null;
        }
    }
    public static ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
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