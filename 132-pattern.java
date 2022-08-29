class Solution {
    
    // 3 1 4 2
    // 1 2 3 4
    public boolean find132pattern(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < s3){
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                s3 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}