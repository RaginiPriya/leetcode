class Solution {
    
    // 2 1
    // 1 2
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0 ,1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int rowLength = heights.length;
        int colLength = heights[0].length;
        
        boolean[][] pacific = new boolean[rowLength][colLength];
        boolean[][] atlantic = new boolean[rowLength][colLength];
        
        for(int i = 0; i < rowLength; i++){
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, colLength - 1, atlantic, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < colLength; i++){
            dfs(heights, 0, i, pacific, Integer.MIN_VALUE);
            dfs(heights, rowLength - 1, i, atlantic, Integer.MIN_VALUE);
        }
        
        
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int height){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j] || heights[i][j] < height){
            return;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            dfs(heights, i + dir[0], j + dir[1], visited, heights[i][j]);
        }
    }
}