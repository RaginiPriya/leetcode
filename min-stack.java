class MinStack {
    
    Node head;

    class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    Stack<Node> stack;
    
    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        
        Node node;
        
        if(head == null){
            head = new Node(val, val);
        }
        else{
            if(head.min > val){
                node = new Node(val, val);
            }
            else{
                node = new Node(val, head.min);
            }
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */