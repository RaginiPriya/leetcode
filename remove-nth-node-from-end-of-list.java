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

// dummy 1 2 3 4 5
//           f     s
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = head;
        
        for(int i = 0; i < n && second != null; i++){
            second = second.next;
        }
        
        while(second != null){
            second = second.next;
            first = first.next;
        }
        
        if(first.next != null){
            first.next = first.next.next;
        }
        else{
            first.next = null;
        }
        
        return dummy.next;
        
    }
}