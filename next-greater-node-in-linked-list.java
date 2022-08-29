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

// maxVal=7
// count=2
// index=2

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        
        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < list.size(); i++){
            int val = list.get(i);
            while(!stack.isEmpty() && list.get(stack.peek()) < val){
                result[stack.pop()] = val;
            }
            stack.push(i);
        }
        
        return result;
    }
}