class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        
        Map<Integer, Integer> sumToCountMap = new HashMap<>();
        sumToCountMap.put(0, 1);
        
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            Integer count = sumToCountMap.get(sum - k);
            if(count != null){
                result += count;
            }
            Integer currCount = sumToCountMap.get(sum);
            if(currCount == null){
                currCount = 0;
            }
            sumToCountMap.put(sum, currCount + 1);
        }
        
        return result;
    }
}