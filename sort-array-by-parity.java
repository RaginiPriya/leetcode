class Solution {
    
    // 2 4 3 1
    public int[] sortArrayByParity(int[] nums) {
        
        int left = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                left++;
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
            }
        }
        
        return nums;
    }
}