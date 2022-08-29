class Solution {
    
    // 0 0 0 0 
    // 0 1 0 0
    // 0 0 0 0
    // 0 0 1 0
    // 0 0 0 0
    
    // backtracking is not going to work here since we won't know if cell is obstacle or if 1 path goes through it.
    // so we need to use dp top down approach
    // in order to not have condition to check if 1st column or 1st row, we populate them separately first
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rowL = obstacleGrid.length;
        int colL = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
//         obstacleGrid[0][0] = 1;
        
//         for(int i = 1; i < rowL; i++){
//             if(obstacleGrid[i][0] != 1 && obstacleGrid[i - 1][0] == 1){
//                 obstacleGrid[i][0] = 1;
//             }
//             else{
//                 obstacleGrid[i][0] = 0;
//             }
//         }
        
//         for(int i = 1; i < colL; i++){
//             if(obstacleGrid[0][i] != 1 && obstacleGrid[0][i - 1] == 1){
//                 obstacleGrid[0][i] = 1;
//             }
//             else{
//                 obstacleGrid[0][i] = 0;
//             }
//         }
        
//         for(int i = 1; i < rowL; i++){
//             for(int j = 1; j < colL; j++){
//                 if(obstacleGrid[i][j] != 1){
//                     obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
//                 }
//                 else{
//                     obstacleGrid[i][j] = 0;
//                 }
//             }
//         }
        
//         return obstacleGrid[rowL - 1][colL - 1];
        
        int[] dp = new int[colL];
        
        dp[0] = 1;
        
        for(int i = 0; i < rowL; i++){
            for(int j = 0; j < colL; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[colL - 1];
    }
    
}