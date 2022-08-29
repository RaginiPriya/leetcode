class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        permute(nums, list, new ArrayList<>(), new boolean[nums.length]);
        
        return list;
    }
    
    private void permute(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            permute(nums, list, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}