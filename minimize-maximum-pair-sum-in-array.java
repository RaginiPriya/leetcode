class Solution {
    public int minPairSum(int[] nums) {
        // 2 3 3 5 
        // 2 3 4 4 5 6
        
        // 1 1 1 2 4 4 5 5 5 5
        
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        int max = 0;
        while(left < right){
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }
        
        return max;
    }
}