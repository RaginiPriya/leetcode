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
        
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        
        while(l1 != null){
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        

        ListNode tail = null;
        int sum = 0;
        ListNode node = null;
        
        // 7 2 4 
        // 5 6 
        // 10
        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() || sum > 0){

            if(!l1Stack.isEmpty()){
                sum += l1Stack.pop();
            }
            if(!l2Stack.isEmpty()){
                sum += l2Stack.pop();
            }
            
            node = new ListNode();
            node.val = sum % 10;
            sum = sum / 10;
            node.next = tail;
            tail = node;
        }
        
        return node;
        
    }
}