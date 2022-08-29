class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[2];
        res[0] = search(nums, target, true);
        res[1] = search(nums, target, false);
        return res;
    }
    
    private int search(int[] nums, int target, boolean isStart){
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(isStart && mid > 0 && nums[mid - 1] == nums[mid]){
                    right = mid - 1;
                }
                else if(!isStart && mid < nums.length - 1 && nums[mid + 1] == nums[mid]){
                    left = mid + 1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return -1;
    }
}