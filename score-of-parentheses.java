class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int score = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(0);
            }
            else{
                int left = stack.pop();
                int start = stack.pop();
                stack.push(start + Math.max(2 * left, 1));
            }
        }
        
        return stack.pop();
        
    }
}