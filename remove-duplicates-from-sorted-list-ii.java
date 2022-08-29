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
        
        ListNode dummy = new ListNode(-101);
        ListNode prev = dummy;
        ListNode node = head;
        
        while(node != null){
            if(node.next == null){
                prev.next = node;
                break;
            }
            if(node.val != node.next.val){
                prev.next = node;
                prev = node;
                node = node.next;
            }
            else{
                int val = node.val;
                while(node != null && node.val == val){
                    node = node.next;
                }
                if(node == null){
                    prev.next = node;
                }
            }
        }
        return dummy.next;
    }
}