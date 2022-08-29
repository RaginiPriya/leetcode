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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddH = odd;
        ListNode evenH = even;
        
        while(odd != null && even != null){
            odd.next = even.next;
            if(odd.next == null){
                break;
            }
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        
        odd.next = evenH;
        
        return oddH;
        
    }
}