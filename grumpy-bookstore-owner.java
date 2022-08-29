class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = minutes - 1;
        
        int result = 0;
        
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                result += customers[i];
            }
        }
        
        for(int i = left; i <= right; i++){
            if(grumpy[i] == 1){
                result += customers[i];
            }
        }

        left++;
        right++;
        
        int temp = result;
        while(right < customers.length){
            if(grumpy[left - 1] == 1){
                temp -= customers[left - 1];
            }
            if(grumpy[right] == 1){
                temp += customers[right];
            }
            left++;
            right++;
            result = Math.max(result, temp);
        }
        
        return result;
    }
}