class MyCircularQueue {
    
    int front = 0;
    int rear = -1;
    int length = 0;
    
    int[] arr;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        length++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % arr.length;
        length--;
        return true;
    }
    
    public int Front() {
        return length == 0 ? -1 : arr[front];
    }
    
    public int Rear() {
        return length == 0 ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public boolean isFull() {
        return length == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */