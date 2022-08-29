class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (x, y) -> {
            if(x[0] == y[0]){
                return Integer.compare(y[1], x[1]);
            }
            return Integer.compare(x[0], y[0]) ;
        });
        
        int[] dp = new int[envelopes.length];
        
        int size = 0;
        
        for(int[] envelope: envelopes){
            int left = 0;
            int right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] < envelope[1]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            dp[left] = envelope[1];
            if(left == size){
                size++;
            }
        }
        
        return size;
    }
}