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
    public ListNode partition(ListNode head, int x) {
        
        // ListNode firstHead = new ListNode();
//         ListNode secondHead = new ListNode();
        
//         ListNode node = head;
        
//         ListNode first = firstHead;
//         ListNode second = secondHead;
        
//         while(node != null){
//             if(node.val < x){
//                 first.next = node;
//                 first = first.next;
//             }
//             else {
//                 second.next = node;
//                 second = second.next;
//             }
//             node = node.next;
//         }
        
//         first.next = secondHead.next;
        
//         return firstHead.next;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode node = head;
        
        ListNode left = dummy;
        ListNode prev = dummy;
        
        while(node != null){
            if(node.val < x){
                if(left.next == node){
                    left = left.next;
                    prev = node;
                    node = node.next;
                }
                else{
                    prev.next = node.next;
                    ListNode next = left.next;
                    left.next = node;
                    node.next = next;
                    left = node;
                    node = prev.next;
                }
            }
            else{
                prev = node;
                node = node.next;
            }
        }
        
        return dummy.next;
        
    }
}