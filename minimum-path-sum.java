class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return min(grid, 0, 0, dp);
    }
    
    private int min(int[][] grid, int i, int j, int[][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int val = Math.min(min(grid, i + 1, j, dp), min(grid, i, j + 1, dp));
        
        dp[i][j] = val + grid[i][j];
        return dp[i][j];
        
    }
}