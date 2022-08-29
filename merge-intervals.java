class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        
        List<int[]> list = new ArrayList<>();
        
        list.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if(last[1] >= curr[0]){
                int end = Math.max(last[1], curr[1]);
                list.remove(list.size() - 1);
                last[1] = end;
                list.add(last);
            }
            else{
                list.add(curr);
            }
        }
        
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}