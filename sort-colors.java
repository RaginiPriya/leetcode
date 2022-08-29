class Solution {
    // 2 0 2 1 1 0
    // 0 0 2 1 1 2
    // 0 0 1 1 2 2
    public void sortColors(int[] nums) {
        
        int zeroPointer = 0;
        int secondPointer = nums.length;
        
        int index = 0;
        
        while(index < secondPointer){

            if(nums[index] == 0){
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[index];
                nums[index] = temp;
                zeroPointer++;
                index++;
            }
            else if(nums[index] == 2){
                secondPointer--;
                int temp = nums[secondPointer];
                nums[secondPointer] = nums[index];
                nums[index] = temp;
                
            }
            else{
                index++;
            }
            
        }
    }
}