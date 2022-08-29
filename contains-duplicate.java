class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.get(num) != null){
                return true;
            }
            else{
                map.put(num, 1);
            }
        }
        
        return false;
        
    }
}