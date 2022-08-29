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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode first = head;
        ListNode second = head;
        
        while(second != null && second.next != null){
            stack.push(first);
            first = first.next;
            second = second.next;
            if(second != null){
                second = second.next;
            }
        }
        
        if(second != null){
            first = first.next;
        }
        
        while(!stack.isEmpty() && first != null){
            if(first.val != stack.peek().val){
                return false;
            }
            stack.pop();
            first = first.next;
        }
        
        if(stack.isEmpty() && first == null){
            return true;
        }
        
        return false;
        
    }
}