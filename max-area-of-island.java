class Solution {
    
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, visited, i, j));
                }
            }
            
        }
        
        return max;
        
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        
        visited[i][j] = true;
        
        int area = 0;
        
        for(int[] direction : directions){
            area += dfs(grid, visited, i + direction[0], j + direction[1]);
        }
        
        return 1 + area;
    }
}