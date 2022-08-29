/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // 4 2 1 3
    //     f     s
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;
        
        while(second != null && second.next != null){
            prev = first;
            first = first.next;
            second = second.next.next;
        }
        
        // ListNode next = first.next;
        // first.next = null;
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(first);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode prev = head;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        if(l1 != null){
            prev.next = l1;
        }
        else if(l2 != null){
            prev.next = l2;
        }
        
        return head.next;
    }
}