class Solution {
    
    // -2 1 -3 4 -1 2 1 -5 4
    // -2
    public int maxSubArray(int[] nums) {
        
        int dp[] = new int[nums.length];
        int max = nums[0];
        
        dp[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] + dp[i - 1] > nums[i]){
                dp[i] = nums[i] + dp[i - 1];
            }
            else{
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }
}