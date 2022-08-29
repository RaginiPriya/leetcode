class Solution {
    
    // 1 1 1
    // 1 0 1
    // 1 1 1
    
    public int largest1BorderedSquare(int[][] grid) {
        
        int max = 0;
        
        int[][] hor = new int[grid.length][grid[0].length];
        int[][] ver = new int[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(j != 0){
                        hor[i][j] = hor[i][j - 1] + 1;
                    }
                    else{
                        hor[i][j] = 1;
                    }
                    if(i != 0){
                        ver[i][j] = ver[i - 1][j] + 1;
                    }
                    else{
                        ver[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = grid.length - 1; i >= 0; i--){
            for(int j = grid[0].length - 1; j >= 0; j--){
                int val = Math.min(hor[i][j], ver[i][j]);
                while(val > max){
                    if(ver[i][j - val + 1] >= val && hor[i - val + 1][j] >= val){
                        max = val;
                        break;
                    }
                    val = val - 1;
                }
            }
        }
        
        return max * max;
    }
}