class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int min = nums[0];
        int max = nums[nums.length - 1];
        
        int res = max - min;
        
        for(int i = 0; i < nums.length - 1; i++){
            
            // we will have nums[0] + 2 * k because we need minimum difference so we should rather have nums[0] + 2 * k instead of nums[0] as minimum
            min = Math.min(nums[0] + 2 * k, nums[i + 1]);
            // max will have nums[nums.length - 1]
            max = Math.max(max, nums[i] + 2 * k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}