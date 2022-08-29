class Solution {
    
    //  0   0   0   0
    //  0   0   1   1
    //  0   1   2   2
    //  0   1   2   3
    
    // 0 0 0 0
    // 0 1 2 1
    // 0 0 0 0
    // 0 0 0 0
    
    public int maxDistance(int[][] grid) {
        
//         int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
//         Queue<int[]> queue = new ArrayDeque<>();
        
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid.length; j++){
//                 if(grid[i][j] == 1){
//                     queue.add(new int[]{i, j});
//                 }
//             }
//         }
        
//         if(queue.size() == 0 || queue.size() == grid.length * grid.length ) {
//             return -1;
//         }
        
//         int level = 0;
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size; i++){
//                 int[] coords = queue.poll();
//                 for(int[] direction : directions){
//                     int row = coords[0] + direction[0];
//                     int col = coords[1] + direction[1];
//                     if(row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0){
//                         grid[row][col] = 1;
//                         queue.add(new int[]{row, col});
//                     }
//                 }
//             }
//             level++;
//         }
//         return level - 1;
        int[][] dp = new int[grid.length][grid.length];
        int max = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = 201;
                    if(i > 0){
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    }
                    if(j > 0){
                        dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                    }
                }
                
                
            }
        }
        
        for(int i = grid.length - 1; i >= 0; i--){
            for(int j = grid.length - 1; j >= 0; j--){
                if(grid[i][j] == 1){
                    dp[i][j] = 1;
                }
                else{
                    if(i < grid.length - 1){
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if(j < grid.length - 1){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                    max = Math.max(max, dp[i][j]);
                }
                
                
            }
        }
        
        return max == 201 ? -1 : max - 1;
        
    }
}