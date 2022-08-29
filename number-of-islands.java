class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        
        int noOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, visited, i, j);
                    noOfIslands++;
                }
            }
        }
        
        return noOfIslands;
        
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            dfs(grid, visited, i + dir[0], j + dir[1]);
        }
    }
}