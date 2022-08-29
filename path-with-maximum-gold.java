class Solution {
    
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int getMaximumGold(int[][] grid) {
        
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    int gold = dfs(grid, i, j, visited);
                    max = Math.max(max, gold);
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        
        visited[i][j] = true;
        
        int val = 0;
        
        for(int[] direction : directions){
            val = Math.max(val, dfs(grid, i + direction[0], j + direction[1], visited));
        }
        
        visited[i][j] = false;
        
        return grid[i][j] + val;
    }
}