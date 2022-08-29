class MyQueue {
    
    // 1 2 3
    // 3 2 
    
    Stack<Integer> push = new Stack<>();
    Stack<Integer> pop = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        push.push(x);
    }
    
    public int pop() {
        if(!pop.isEmpty()){
            return pop.pop();
        }
        else{
            while(!push.isEmpty()){
                pop.push(push.pop());
            }
            return pop.pop();
        }
    }
    
    public int peek() {
        if(pop.isEmpty()){
            int popVal = pop();
            pop.push(popVal);
        }
        return pop.peek();
    }
    
    public boolean empty() {
        return push.isEmpty() && pop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */