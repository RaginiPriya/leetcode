class Solution {
    
    // 4 5 6 7 0 1 2
    //         l   r
    
    // 2 1
    // l r
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[left]){
                if(nums[mid] < nums[right]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}