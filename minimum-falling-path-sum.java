class Solution {
    
    // 2 1 3
    // 6 5 4
    // 7 8 9
    
    // 2 1 3
    // 
    public int minFallingPathSum(int[][] matrix) {
        
        // int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = matrix[0][i];
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                int min = Integer.MAX_VALUE;
                if(j > 0){
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                min = Math.min(dp[i - 1][j], min);
                if(j < dp[0].length - 1){
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < dp[0].length; i++){
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        
        return res;
        
//         for(int i = 0; i < matrix[0].length; i++){
//             min = Math.min(min, dfs(0, i, matrix, dp));
//         }
        
//         return min;
        
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(j < 0 || j >= matrix[0].length){
            return 101;
        }
        if(i == matrix.length - 1){
            return matrix[i][j];
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        int val = matrix[i][j];
        int next = Math.min(dfs(i + 1, j - 1, matrix, dp), Math.min(dfs(i + 1, j, matrix, dp), dfs(i + 1, j + 1, matrix, dp)));
        
        dp[i][j] = val + next;
        return dp[i][j];
    }
}