class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return fourSum(nums, target, 4, 0);
    }
    
    private List<List<Integer>> fourSum(int[] nums, int target, int k, int index){
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(k == 2){
            int left = index;
            int right = nums.length - 1;
            
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        else{
            for(int i = index; i < nums.length - k + 1; i++){
                if(i != index && nums[i] == nums[i - 1]){
                    continue;
                }
                List<List<Integer>> list = fourSum(nums, target - nums[i], k - 1, i + 1);
                for(List<Integer> listEl : list){
                    listEl.add(0, nums[i]);
                }
                result.addAll(list);
            }
        }
        return result;
    }
}