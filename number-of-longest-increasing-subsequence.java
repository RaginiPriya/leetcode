class Solution {
    
    // 1 3 5 4 7
    // 1 2 3 3 4
    // 1 1 1 1 2
    
    public int findNumberOfLIS(int[] nums) {
        
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        int maxLength = 1;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(length[j] + 1 == length[i]){
                        count[i] += count[j];
                    }
                    else if(length[j] + 1 > length[i]){
                        count[i] = count[j];
                        length[i] = length[j] + 1;
                    }
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }
        
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(length[i] == maxLength){
                result += count[i];
            }
        }
        
        return result;
        
    }
}