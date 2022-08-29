class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        subsets(nums, 0, list, new ArrayList<>());
        
        return list;
    }
    
    private void subsets(int[] nums, int start, List<List<Integer>> list, List<Integer> temp){
        
        list.add(new ArrayList<>(temp));
        
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            subsets(nums, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }
}