class Solution {
    
    // 0 1 0 3 12
    // 1 3 12 0 0 
    public void moveZeroes(int[] nums) {
        
        int index = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[++index] = nums[i];
                if(index != i){
                    nums[i] = 0;
                }
                
            }
        }
    }
}