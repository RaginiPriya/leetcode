class Solution {
    public int calculate(String s) {
        
        int result = 0;
        int lastSign = 1;
        int num = 0;
        Stack<Integer> lastSigns = new Stack<>();
        lastSigns.push(1);
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }
            else {
                if(c == '+' || c == '-'){
                    result += num * lastSign;
                    num = 0;
                    lastSign = (c == '+' ? 1 : -1) * lastSigns.peek();
                }
                else if(c == '('){
                    lastSigns.push(lastSign);
                }
                else if(c == ')'){
                    lastSigns.pop();
                }
            }
        }
        result += lastSign * num;
        return result;
    }
}