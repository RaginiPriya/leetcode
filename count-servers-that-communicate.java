class Solution {
    
    // 1 1 0 0
    // 0 0 1 0
    // 0 0 1 0
    // 0 0 0 1
    
    // row 2 1 1 1
    // col 1 1 2 1
    
    public int countServers(int[][] grid) {
        
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        
        for(int i = 0; i < row.length; i++){
            for(int j = 0; j < col.length; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < row.length; i++){
            for(int j = 0; j < col.length; j++){
                if(grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)){
                    count++;
                }
            }
        }
        
        return count;
        
        
    }
}