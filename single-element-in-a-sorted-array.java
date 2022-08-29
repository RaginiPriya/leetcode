class Solution {
    
    // e o e o e o e 
    // 0 1 2 3 4 5 6 
    
    // 3 3 7 7 10 11 11
    // l     m l   m  r
    
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if((mid % 2 == 0 && nums[mid + 1] != nums[mid]) || (mid % 2 != 0 && nums[mid - 1] != nums[mid])){
                right = mid;
            }
            else{
                left = mid + 1;
            }
            
        }
        
        return nums[left];
    }
}