class Solution {
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        
        int maxLen = 1;
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                start = i;
                end = i + 1;
                maxLen = 2;
                dp[i][i + 1] = true;
            }
        }
        
        for(int k = 2; k < s.length(); k++){
            for(int i = 0; i + k < s.length(); i++){
                int j = i + k;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    int len = j - i + 1;
                    if(len > maxLen){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}