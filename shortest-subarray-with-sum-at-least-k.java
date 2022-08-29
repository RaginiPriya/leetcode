class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        long[] prefix = new long[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        int minLength = nums.length + 1;
        
        for(int i = 0; i <= nums.length; i++){
            while(!queue.isEmpty() && prefix[i] - prefix[queue.getFirst()] >= k){
                minLength = Math.min(minLength, i - queue.pollFirst());
            }
            while(!queue.isEmpty() && prefix[i] <= prefix[queue.getLast()]){
                queue.pollLast();
            }
            queue.addLast(i);
        }
        
        return minLength <= nums.length ? minLength : -1;
    }
}