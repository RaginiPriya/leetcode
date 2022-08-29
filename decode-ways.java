class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= s.length(); i++){
            int oneChar = s.charAt(i - 1) - '0';
            // int twoChar = Integer.valueOf(s.substring(i - 2, i));
            int twoChar = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            
            if(oneChar >= 1 && oneChar <= 9){
                dp[i] += dp[i - 1];
            }
            if(twoChar >= 10 && twoChar <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
        
    }
}