class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;
        
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }
        
        while(left < right){
            
            int mid = left + (right - left) / 2;
            
            int count = 0;
            
            for(int i = 0; i < piles.length; i++){
                count += piles[i] / mid;
                
                if(piles[i] % mid > 0){
                    count++;
                }
            }
            
            if(count <= h){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}