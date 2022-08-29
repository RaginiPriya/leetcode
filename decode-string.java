class Solution {
    public String decodeString(String s) {
        
        // intStack 
        // strStack 
        
        // cur = accaccacc
        // k = 0
        
        // tmp = acc
        

        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        int k = 0;
        StringBuilder curr = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + c - '0';
            }
            else if(c == '['){
                intStack.push(k);
                strStack.push(curr);
                k = 0;
                curr = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder prev = strStack.pop();
                int count = intStack.pop();
                for(int i = 0; i < count; i++){
                    prev.append(curr);
                }
                curr = prev;
            }
            else{
                curr.append(c);
            }
        }
        
        return curr.toString();
    }
}