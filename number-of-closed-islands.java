class Solution {
    
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 0){
                    if(dfs(grid, visited, i, j)){
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }
        if(visited[i][j] || grid[i][j] == 1){
            return true;
        }
        
        visited[i][j] = true;
        
        boolean valid = true;
        
        for(int[] direction : directions){
            valid = valid & dfs(grid, visited, i + direction[0], j + direction[1]);
        }
        
        return valid;
    }
}