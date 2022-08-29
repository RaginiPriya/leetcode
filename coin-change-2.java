class Solution {
    
    // 0 1 2 3 4 5
    // 1 1 2 2 3 4
    
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j < dp.length; j++){
                if(coins[i] <= j){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        
        return dp[amount];
    }
}