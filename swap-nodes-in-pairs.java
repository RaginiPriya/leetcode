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

//      1 2 3 4
//          p e n
//  dummy -> 2 -> 1 -> 4 -> 3
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        
        ListNode node = head;
        
        while(node != null){
            if(node.next == null){
                prev.next = node;
                prev = node;
                break;
            }
            else{
                ListNode next = node.next;
                prev.next = next;
                ListNode temp = next.next;
                next.next = node;
                prev = node;
                node = temp;
            }
        }
        prev.next = null;
        
        return dummy.next;
    }
}