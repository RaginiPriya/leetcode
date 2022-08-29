class Solution {
    
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        
        return 0;
    }
    
    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }
        int count = 0;
        grid[i][j] = -1;
        for(int[] dir : dirs){
            count += dfs(grid, i + dir[0], j + dir[1]);
        }
        
        return count;
    }
}