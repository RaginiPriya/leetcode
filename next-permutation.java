class Solution {
    
    // 1 2 5 4 3
    // 1 3 5 4 2
    
    // min=2
    
    // 1 3 2
    // i
    // 2 3 1
    
    public void nextPermutation(int[] nums) {
        
        int i = nums.length - 1;
        
        while(i > 0 && nums[i - 1] >= nums[i]){
            i--;
        }
        
        if(i == 0){
            Arrays.sort(nums);
            return;
        }
        
        i--;
         
        int min = Integer.MAX_VALUE;
        int swapIndex = i;
        
        for(int index = i + 1; index < nums.length; index++){
            if(nums[index] <= min && nums[index] > nums[i]){
                swapIndex = index;
                min = nums[index];
            }
        }

        int temp = nums[i];
        nums[i] = nums[swapIndex];
        nums[swapIndex] = temp;
        
        
        
        int left = i + 1;
        int right = nums.length - 1;
        
        while(left < right){
            int temp2 = nums[left];
            nums[left] = nums[right];
            nums[right] = temp2;
            left++;
            right--;
        }
    }
}