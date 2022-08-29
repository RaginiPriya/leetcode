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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null){
            int sum = p1.val + p2.val + carry;
            if(sum > 9){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            prev.next = node;
            prev = node;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode pointer = null;
        
        if(p1 != null){
            pointer = p1;
        }
        else if(p2 != null){
            pointer = p2;
        }
        
        while(pointer != null && carry != 0){
            int sum = pointer.val + carry;
            if(sum > 9){
                carry = 1;
                sum = sum % 10;
            }
            else{
                carry = 0;
            }
            pointer.val = sum;
            prev.next = pointer;
            prev = pointer;
            pointer = pointer.next;
        }
        
        if(pointer != null){
            prev.next = pointer;
        }
        else if(carry == 1){
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        
        return dummy.next;
    }
}