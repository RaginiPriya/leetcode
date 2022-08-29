class Solution {
    
    public int reverse(int x) {
        
        int res = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        
        while(x > 0){
            int digit = x % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
            res = res * 10 + digit;

            x = x / 10;
        }
        
        return sign * res;
    }
}