class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int result = 0;
        int count = 0;
        int i = 0;
        
        while(i < nums.length){
            if(nums[i] == 0 && count > 0){
                result = Math.max(result, count);
                count = 0;
            }
            else if(nums[i] == 1){
                count++;
            }
            i++;
        }
        
        if(count > 0){
            result = Math.max(count, result);
        }
        
        return result;
    }
}