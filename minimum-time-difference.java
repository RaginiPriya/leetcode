class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        boolean[] dp = new boolean[24 * 60];
        
        for(String time : timePoints){
            String[] arr = time.split(":");
            int i = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
            if(dp[i] == true){
                return 0;
            }
            dp[i] = true;
        }
        
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < dp.length; i++){
            if(dp[i]){
                if(last != Integer.MIN_VALUE){
                    min = Math.min(min, i - last);
                }
                last = i;
                first = Math.min(first, i);
            }
        }
        
        return Math.min(min, first + (24 * 60 - last));
    }
}