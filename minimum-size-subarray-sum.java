class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int min = nums.length + 1;
        
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        
        return min > nums.length ? 0 : min;
    }
}