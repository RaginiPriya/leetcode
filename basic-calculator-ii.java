class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        
        char[] arr = s.toCharArray();
        int num = 0;
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c != ' ' || i == arr.length - 1){
                switch(lastSign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                lastSign = c;
                num = 0;
            }
            
        }
        
        int result = 0;
        
        for(int n : stack){
            result += n;
        }
        
        return result;
        
    }
}