class Solution {
    
    // 1,2 1,3 2,3 2,4
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (x, y) -> {
            // if(x[0] == y[0]){
            //     return Integer.compare(x[1], y[1]);
            // }
            return Integer.compare(x[1], y[1]);
        });
        
        int count = 0;
        
        int[] last = intervals[0];
        
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < last[1]){
                count++;
            }
            else{
                last = curr;
            }
        }
        
        return count;
    }
}