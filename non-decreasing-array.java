class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int count = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                // either increase i or decrease i-1
                // to decrese i-1, we need to validate with i-2
                
                count++;
                if(count > 1){
                    return false;
                }
                
                if(i - 2 < 0 || nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i];
                }
                else{
                    nums[i] = nums[i - 1];
                }
            }
        }
        
        return true;
    }
}