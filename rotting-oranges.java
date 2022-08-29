class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        int ones = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    ones++;
                }
            }
        }
        
        int minutes = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean didItHappen = false;
            
            for(int i = 0; i < size; i++){
                int[] coord = queue.poll();
                int row = coord[0];
                int col = coord[1];
                
                for(int[] dir : directions){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    
                    if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 1){
                        grid[nextRow][nextCol] = 2;
                        queue.add(new int[]{nextRow, nextCol});
                        didItHappen = true;
                        ones--;
                    }
                }
            }
            if(didItHappen){
                minutes++;
            }
            
        }
        
        return ones > 0 ? -1 : minutes;
    }
}