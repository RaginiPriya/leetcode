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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> {
            return x.val - y.val;
        });
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }
        
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            prev.next = node;
            if(node.next != null){
                queue.add(node.next);
            }
            prev = node;
        }
        
        return dummy.next;
    }
}