class Solution {
    
    // [  /]
    // [/  ]
    
    // 0,1
    
    // 0,5
    // 1,4
    // 2,3
    
    // [0 0 0 0 0 1]
    // [0 0 0 0 1 0]
    // [0 0 0 1 0 0]
    // [0 0 1      ]
    // [0 1 0      ]
    // [1 0 0      ]
    
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int regionsBySlashes(String[] grid) {
        
        int[][] new_grid = new int[grid.length * 3][grid[0].length() * 3];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length(); j++){
                if(grid[i].charAt(j) == '/'){
                    new_grid[i * 3][j * 3 + 2] = 1;
                    new_grid[i * 3 + 1][j * 3 + 1] = 1;
                    new_grid[i * 3 + 2][j * 3] = 1;
                }
                else if(grid[i].charAt(j) == '\\'){
                    new_grid[i * 3][j * 3] = 1;
                    new_grid[i * 3 + 1][j * 3 + 1] = 1;
                    new_grid[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < new_grid.length; i++){
            for(int j = 0; j < new_grid[0].length; j++){
                if(new_grid[i][j] == 0){
                    dfs(new_grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;
        
        for(int[] direction : directions){
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }
}