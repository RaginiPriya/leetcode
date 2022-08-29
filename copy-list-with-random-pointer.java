/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node node = head;
        Node secondHead = null;
        
        while(node != null){
            Node second = new Node(node.val);
            second.next = node.next;
            node.next = second;
            node = second.next;
        }
        
        node = head;
        
        while(node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            
            node = node.next.next;
        }
        
        node = head;
        
        while(node != null){
            Node second = node.next;
            if(secondHead == null){
                secondHead = second;
            }
            node.next = second.next;
            if(node.next != null){
                second.next = node.next.next;
            }
            else{
                second.next = null;
            }
            node = node.next;
        }
        
        return secondHead;
        
    }
}