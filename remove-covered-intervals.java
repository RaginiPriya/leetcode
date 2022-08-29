class Solution {
    
    
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (x, y) -> {
            if(x[0] == y[0]){
                return Integer.compare(y[1], x[1]);
            }
            return Integer.compare(x[0], y[0]);
        });
        
        List<int[]> list = new ArrayList<>();
        
        list.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            
            if(curr[0] >= last[0] && curr[1] <= last[1]){
                continue;
            }
            else{
                list.add(curr);
            }
        }
        
        return list.size();
    }
}