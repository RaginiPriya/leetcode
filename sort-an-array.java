class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private int partition(int[] nums, int left, int right){
        
        int small = left;
        int index = left;
        int pivot = nums[right];
        
        while(index < right){
            if(nums[index] < pivot){
                int temp = nums[small];
                nums[small] = nums[index];
                nums[index] = temp;
                small++;
            }
            index++;
        }
        
        nums[right] = nums[small];
        nums[small] = pivot;
        return small;
    }
    
    private void quickSort(int[] nums, int left, int right){
        
        if(left < right){
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }
}