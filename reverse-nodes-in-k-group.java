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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        
        ListNode start = head;
        ListNode node = head;
        
        int count = 0;
        
        while(node != null){
            count++;
            if(count % k == 0){
                ListNode nextStart = node.next;
                node.next = null;
                ListNode currLast = rev(start, prev);
                prev = currLast;
                start = nextStart;
                node = nextStart;
            }
            else{
                node = node.next;
            }
        }
        
        if(start != null){
            prev.next = start;
        }
        
        return dummy.next;
        
    }
    
    private ListNode rev(ListNode start, ListNode head){
        ListNode curr = start;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = prev;
        return start;
    }
}