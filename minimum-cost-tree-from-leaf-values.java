class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        
        for(int num : arr){
            while(stack.peek() <= num){
                res += stack.pop() * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        
        while(stack.size() > 2){
            res += stack.pop() * stack.peek();
        }
        
        return res;
    }
}