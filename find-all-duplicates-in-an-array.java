class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] < 0){
                list.add(Math.abs(nums[i]));
            }
            else{
                nums[val] = - nums[val];
            }
        }
        
        return list;
    }
}