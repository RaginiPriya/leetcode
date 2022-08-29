class Solution {
    
    // 1 1 1 2 2 3
    // 1 1 2 2 3
    // index=2
    // count=1
    
    public int removeDuplicates(int[] nums) {
        
//         int index = 1;
        
//         int count = 1;
        
//         for(int i = 1; i < nums.length; i++){
//             if(nums[i] == nums[i - 1]){
//                 count++;
//             }
//             else{
//                 count = 1;
//             }
//             if(count <= 2){
//                 nums[index++] = nums[i];
//             }
//         }
        
//         return index;
        
        int i = 0;
        
        for(int num : nums){
            if(i < 2 || num > nums[i - 2]){
                nums[i++] = num;
            }
        }
        
        return i;
    }
}