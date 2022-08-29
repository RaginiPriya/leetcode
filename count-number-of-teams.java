class Solution {
    
    public int numTeams(int[] rating) {
        
        // dp has number of increasing sequences at that point
        
        int[] dp = new int[rating.length];
        int count = 0;
        
        for(int i = 1; i < rating.length; i++){
            for(int j = 0; j < i; j++){
                if(rating[i] > rating[j]){
                    dp[i]++;
                    count += dp[j];
                }
            }
        }
        
        Arrays.fill(dp, 0);
        
        for(int i = 1; i < rating.length; i++){
            for(int j = 0; j < i; j++){
                if(rating[i] < rating[j]){
                    dp[i]++;
                    count += dp[j];
                }
            }
        }
        
        return count;
        
    }
}