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

// 1 2 3  
//     p
// 1 -> 5 -> 2 -> 4 -> 3 4 5
//                     n ne

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        
        node = head;
        
        while(node != stack.peek()){
            ListNode next = node.next;
            ListNode pop = stack.pop();
            node.next = pop;
            if(pop == next){
                node = pop;
                break;
            }
            pop.next = next;
            node = next;
        }
        node.next = null;
        
    }
}