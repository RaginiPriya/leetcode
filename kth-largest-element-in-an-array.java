class Solution {
    
    // 0 1 2 3 4 5
    // 3 2 1 5 6 4
    //         2
    public int findKthLargest(int[] nums, int k) {
        
        int position = nums.length - k;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int pos = partition(nums, left, right);
            if(pos == position){
                return nums[pos];
            }
            else if(pos < position){
                left = pos + 1;
            }
            else{
                right = pos - 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int left, int right){
        int index = left;
        int pivot = nums[right];
        
        while(index < right){
            if(nums[index] < pivot){
                swap(nums, left, index);
                left++;
            }
            index++;
        }
        swap(nums, left, right);
        return left;
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}