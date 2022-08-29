class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int totalSum = 0;
        int F = 0;
        
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
            F += i * nums[i];
        }
        
        int max = F;
        
        for(int i = nums.length - 1; i > 0; i--){
            F = F + totalSum - nums.length * nums[i];
            max = Math.max(max, F);
        }
        return max;
    }
}