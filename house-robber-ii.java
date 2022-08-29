class Solution {
    public int rob(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length + 1];
        
        // 0 to n - 1
        dp[1] = nums[0];
        int i = 0;
        
        for(i = 1; i < nums.length - 1; i++){
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        
        int max = dp[i];
        
        // 1 to n
        dp[1] = 0;
        dp[2] = nums[1];
        
        for(i = 2; i < nums.length; i++){
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        
        return Math.max(max, dp[i]);
    }
}