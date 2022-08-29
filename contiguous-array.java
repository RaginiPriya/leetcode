class Solution {
    public int findMaxLength(int[] nums) {
        
        int max = 0;
        
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        
        sumToIndex.put(0, -1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum += -1;
            }
            else{
                sum += 1;
            }
            Integer index = sumToIndex.get(sum);
            if(index != null){
                max = Math.max(max, i - index);
            }
            else{
                sumToIndex.put(sum, i);
            }
            
        }
        
        return max;
    }
}