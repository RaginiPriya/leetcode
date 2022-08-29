class Solution {
    
    // 7 6 5 4 3 2 1
    // 5 6 7 1 2 3 4
    
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        
        left = 0;
        right = k - 1;
        
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        
        left = k;
        right = nums.length - 1;
        
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        
    }
}