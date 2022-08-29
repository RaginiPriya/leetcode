class Solution {
    
    //1 1 0 1
    
    //0 1 1 1 0 1 1 0 1
    //  l           r
    public int longestSubarray(int[] nums) {
        
        int left = 0;
        int right = 0;
        
        boolean isZero = false;
        int zeroIndex = -1;
        int max = 0;
        
        while(right <= nums.length){
            
            if(right == nums.length){
                max = Math.max(max, right - left - 1);
                break;
            }
            
            if(nums[right] == 1){
                right++;
            }
            else if(nums[right] == 0 && !isZero){
                isZero = true;
                zeroIndex = right;
                right++;
            }
            else if(nums[right] == 0 && isZero){
                max = Math.max(max, right - left - 1);
                left = zeroIndex + 1;
                zeroIndex = right;
                right++;
            }
        }
        
        return max;
    }
}