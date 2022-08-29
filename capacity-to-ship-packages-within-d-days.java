class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < weights.length; i++){
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            int index = 0;
            int day = 1;
            int weight = 0;
            while(index < weights.length){
                int val = weight + weights[index];
                if(val <= mid){
                    weight = val;
                }
                else{
                    day++;
                    weight = weights[index];
                }
                index++;
            }
            
            if(day <= days){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}