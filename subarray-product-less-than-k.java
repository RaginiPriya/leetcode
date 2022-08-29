class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int result = 0;
        int left = 0; 
        int right = 0;
        int prod = 1;
        
        while (right < nums.length) {

			prod = prod * nums[right];

			// if (prod < k) {
			// 	result = result + right - left + 1;
			// 	right++;
			// } else {
			// 	prod = prod / nums[left];
			// 	left++;
			// 	prod = prod / nums[right];
			// }
            
            while(prod >= k && left < nums.length && left <= right){
                prod = prod / nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
		}

        
//         for(int i = 0; i < nums.length; i++){
//             int prod = 1;
//             for(int j = i; j >= 0; j--){
                
//                 prod = prod * nums[j];
//                 if(prod >= k){
//                     dp[i] = j - 1;
//                     break;
//                 }
//                 result++;
//             }
//         }
        
        return result;
    }
}