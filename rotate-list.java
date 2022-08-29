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
    
    // dummy 1 2 3 4 5
    //       f   s   e
    public ListNode rotateRight(ListNode head, int k) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        int size = 0;

        ListNode first = head;
        
        while(first != null){
            size++;
            first = first.next;
        }
        
        if(size <= 1){
            return head;
        }
        k = k % size;
        if(k == 0){
            return head;
        }
        
        ListNode second = head;
        first = head;
        
        for(int i = 0; i < k; i++){
            second = second.next;
        }
        
        while(second != null && second.next != null){
            second = second.next;
            first = first.next;
        }
        
        dummy.next = first.next;
        second.next = head;
        first.next = null;
        
        
        return dummy.next;
        
        
    }
}