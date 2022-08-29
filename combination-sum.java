class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void combinationSum(int[] candidates, int target, int index, int sum, List<Integer> temp, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            temp.add(candidates[i]);
            combinationSum(candidates, target, i, sum + candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}