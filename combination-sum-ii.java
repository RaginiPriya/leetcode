class Solution {
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        combinationSum(nums, 0, list, new ArrayList<>(), 0, target);
        
        return list;
    }
    
    private void combinationSum(int[] nums, int start, List<List<Integer>> list, List<Integer> temp, int sum, int target){
        
        if(sum == target){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum > target){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            combinationSum(nums, i + 1, list, temp, sum + nums[i], target);
            temp.remove(temp.size() - 1);
        }
    }
}