class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, list, new ArrayList<>(), new boolean[nums.length]);
        
        return list;
    }
    
    private void permute(int[] nums, List<List<Integer>> list, List<Integer> temp, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])){
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