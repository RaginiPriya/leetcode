/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Node node = head;
        while(node != null){
            if(node.child != null){
                Node temp = node.child;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = node.next;
                if(node.next != null){
                    node.next.prev = temp;
                }
                
                node.next = node.child;
                node.child.prev = node;
                node.child = null; 
            }
            node = node.next;
        }
        return head;
        
    }
}