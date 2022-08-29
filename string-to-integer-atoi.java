class Solution {
    public int myAtoi(String s) {
        
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        int sign = 1;
        
        if(i < s.length()){
            if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(s.charAt(i) == '+'){
                i++;
            }
        }
        
        long base = 0;
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                base = base * 10 + c - '0';
                if(base > Integer.MAX_VALUE){
                    if(sign > 0){
                        return Integer.MAX_VALUE;
                    }
                    else{
                        return Integer.MIN_VALUE;
                    }
                }
                i++;
            }
            else{
                break;
            }
        }
        
        return (int) base * sign;
    }
}