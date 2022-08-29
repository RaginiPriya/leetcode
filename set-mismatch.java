class Solution {
    
    // 1 2 2 4
    // -1 -2 2 -4 
    // 2
    
    // 2 -2
    public int[] findErrorNums(int[] nums) {
        
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            if(nums[val - 1] < 0){
                res[0] = val;
            }
            else{
                nums[val - 1] = nums[val - 1] * -1;
            }
            
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[1] = i + 1;
            }
        }
        
        return res;
    }
}