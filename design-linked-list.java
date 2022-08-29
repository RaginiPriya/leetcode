class MyLinkedList {
    
    Node head;
    int size = 0;
    
    class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public MyLinkedList() {
        
    }
    
    private Node getNode(int index){
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
    
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        Node node = getNode(index);
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        getNode(size - 1).next = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node nodeBeforeIndex = getNode(index - 1);
        node.next = nodeBeforeIndex.next;
        nodeBeforeIndex.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        if(index == 0){
            Node node = head;
            head = node.next;
            node = null;
        }
        else{
            Node node = getNode(index - 1);
            node.next = node.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */