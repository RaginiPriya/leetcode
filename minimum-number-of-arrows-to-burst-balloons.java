class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (x, y) -> {
            return Integer.compare(x[1], y[1]);
        });
        
        int end = points[0][1];
        int count = 1;
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                continue;
            }
            end = points[i][1];
            count++;
        }
        
        return count;
    }
}