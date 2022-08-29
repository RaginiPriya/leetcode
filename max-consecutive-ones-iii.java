class Solution {
    
    // 0 1 2 3 4 5 6 7 8 9 10
    // 1 1 1 0 0 0 1 1 1 1 0 
    //           l           r
    
    // flipped=2
    // firstFlipped=[  10
    
//     public int longestOnes(int[] nums, int k) {
        
//         int left = 0;
//         int right = 0;
        
//         int max = 0;
//         int flipped = 0;
        
//         while(right < nums.length){
//             if(nums[right] == 0){
//                 if(flipped == k){
//                     max = Math.max(max, right - left);
//                     while(nums[left] != 0){
//                         left++;
//                     }
//                     left++;
//                     flipped--;
//                 }               
//                 flipped++;
//             }
//             right++;
//         }
        
//         return Math.max(max, right - left);
//     }
    
    public int longestOnes(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}