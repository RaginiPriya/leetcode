class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            while(k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : stack){
            if(c == '0' && sb.length() == 0){
                continue;
            }
            sb.append(c);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}