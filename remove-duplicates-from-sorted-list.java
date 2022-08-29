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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode node = head;
        
        while(node != null && node.next != null){
            if(node.val == node.next.val){
                prev.next = node.next;
            }
            else{
                prev = prev.next;
            }
            
            node = node.next;
        }
        
        return dummy.next;
    }
}