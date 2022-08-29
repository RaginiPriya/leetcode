class Solution {
    public int removeDuplicates(int[] nums) {
        
        int firstPointer = 0;
        int secondPointer = 1;
        int length = nums.length;
        
        while(secondPointer < length){
            boolean isDuplicate = false;
            while(secondPointer < length && nums[firstPointer] == nums[secondPointer]){
                isDuplicate = true;
                secondPointer++;
            }
            
            if(isDuplicate){
                
                for(int i = secondPointer,j = firstPointer+1; i < length; i++, j++){
                    nums[j] = nums[i];
                }
                length = length - (secondPointer - firstPointer) + 1;
            }
            
                firstPointer++;
                secondPointer = firstPointer + 1;
            
            
        }
        return length;
    }
}