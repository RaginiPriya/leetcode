class MyHashMap {
    
    Node[] arr;
    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        arr = new Node[100];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % arr.length;
        if(arr[index] != null){
            Node node = arr[index];
            Node prev = null;
            while(node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
        }
        else{
            arr[index] = new Node(key, value);
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) % arr.length;
        Node node = arr[index];
        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % arr.length;
        
        Node node = arr[index];
        Node prev = node;
        
        if(node != null && node.key == key){
            arr[index] = node.next;
            return;
        }
        
        while(node != null){
            if(node.key == key){
                prev.next = node.next;
                node = null;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */