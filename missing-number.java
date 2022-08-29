class Solution {
    
    // -5
    public int missingNumber(int[] nums) {
        
        // int[] arr = new int[nums.length + 1];
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            // arr[nums[i]]++;
            sum -= nums[i];
            sum += i;
        }
        
        sum += nums.length;
        
        // for(int i = 0; i < arr.length; i++){
        //     if(arr[i] == 0){
        //         return i;
        //     }
        // }
        // return 0;
        
        return sum;
    }
}