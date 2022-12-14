class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        
        int[] res = new int[nums.length];
        
        for(int i = 0; i < res.length; i++){
            res[i] = -1;
        }
        
        for(int i = 0; i < nums.length * 2; i++){
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                res[stack.pop()] = nums[i % nums.length];
            }
            
            stack.push(i % nums.length);
        }
        
        return res;
    }
}