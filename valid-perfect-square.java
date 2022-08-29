class Solution {

    public boolean isPerfectSquare(int num) {
        
        int left = 1;
        int right = num;
        
        while(left <= right){
            int mid = left + ( right - left) / 2;
            int half = num / mid;
            int rem = num % mid;

            if(half == mid && rem == 0){
                return true;
            }
            else if(half > mid){ // mid is small, go right
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return false;
    }
}