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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left == right){
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        
        ListNode node = head;
        int count = 1;
        
        while(node != null){
            
            if(count == left){
                //rev
                ListNode currPrev = null;
                ListNode begin = node;
                for(int i = count; i <= right; i++){
                    ListNode next = node.next;
                    node.next = currPrev;
                    currPrev = node;
                    node = next;
                }
                
                prev.next = currPrev;
                begin.next = node;
                
                break;
            }
            else{
                prev = node;
                node = node.next;
                count++;
            }
        }
        
        return dummy.next;
    }
}