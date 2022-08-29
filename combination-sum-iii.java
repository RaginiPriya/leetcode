class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, k, n, new ArrayList<>(), 0, 1);
        return result;
    }
    
    private void combination(List<List<Integer>> result, int digits, int target, List<Integer> temp, int sum, int start){
        if(temp.size() == digits && sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i <= 9; i++){
            temp.add(i);
            combination(result, digits, target, temp, sum + i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}