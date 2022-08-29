class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if(sum % k != 0){
            return false;
        }
        
        sum = sum / k;
        boolean[] used = new boolean[nums.length];
        
        return canPart(nums, k, 0, sum, 0, used);
        
    }
    
    private boolean canPart(int[] nums, int parts, int start, int sum, int currSum, boolean[] used){
        if(parts == 1){
            return true;
        }
        if(currSum > sum){
            return false;
        }
        if(currSum == sum){
            return canPart(nums, parts - 1, 0, sum, 0, used);
        }
        for(int i = start; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                if(canPart(nums, parts, i + 1, sum, currSum + nums[i], used)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}