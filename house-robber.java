class Solution {
    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, dp, 0);
    }
    
    private int rob(int[] nums, int[] dp, int index){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] >= 0){
            return dp[index];
        }
        dp[index] = Math.max(nums[index] + rob(nums, dp, index + 2), rob(nums, dp, index + 1));
        return dp[index];
    }
}