/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode first = head;
        ListNode second = head;
        
        while(first != null && second != null){
            first = first.next;
            second = second.next;
            if(second != null){
                second = second.next;
            }
            if(first != null && first == second){
                return true;
            }
        }
        
        return false;
    }
}