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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] res = new ListNode[k];
        
        int len = 0;
        
        ListNode node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        int r = len % k;
        len = len / k;
        
        node = head;
        ListNode prev = null;
        
        for(int i = 0; i < res.length && node != null; i++, r--){
            res[i] = node;
            for(int j = 0; j < len + (r > 0 ? 1 : 0); j++){
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        
        return res;
    }
}