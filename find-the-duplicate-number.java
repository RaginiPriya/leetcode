class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(val < 0){
                val = -val;
            }
            if(nums[val] < 0){
                return val;
            }
            nums[val] = -nums[val];
        }
        
        return -1;
    }
}