class Solution {
    public boolean canJump(int[] nums) {
        
        int dest = 0;
        for(int i = 0; i <= dest; i++){
            dest = Math.max(dest, i + nums[i]);
            if(dest >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}