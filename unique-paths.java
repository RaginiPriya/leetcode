class Solution {
    
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        // dp[m - 1][n - 1] = 1;
        return dfs(m, n, dp, 0, 0);

    }
    
    private int dfs(int rowLength, int colLength, int[][] dp, int i, int j){
        if(i >= rowLength || j >= colLength){
            return 0;
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        if(i == rowLength - 1 && colLength -1 == j){
            return 1;
        }
        
        int n1 = dfs(rowLength, colLength, dp, i + 1, j);
        int n2 = dfs(rowLength, colLength, dp, i, j + 1);
        
        dp[i][j] = n1 + n2;
        
        return dp[i][j];
    }
}