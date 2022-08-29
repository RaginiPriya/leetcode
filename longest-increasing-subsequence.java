class Solution {
    
    // 0 1 0 3 2 3
    // 1 2 1 1 1 1
    
    public int lengthOfLIS(int[] nums) {
        
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         int max = 1;
        
//         for(int i = 1; i < nums.length; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[j] < nums[i] && dp[j] + 1 > dp[i]){
//                     dp[i] = dp[j] + 1;
//                 }
//             }
//             max = Math.max(max, dp[i]);
//         }
        
//         return max;
        
        int[] dp = new int[nums.length];
        int size = 0;
        
        for(int num : nums){
            int left = 0;
            int right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] < num){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            dp[left] = num;
            if(left == size){
                size++;
            }
        }
        
        return size;
    }
}