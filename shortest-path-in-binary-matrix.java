class Solution {
    
    // 0 0 0
    // 1 1 0
    // 1 1 0
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        
        Queue<int[]> queue = new ArrayDeque<>();
        if(grid[0][0] == 0){
            queue.add(new int[]{0, 0});
        }        
        
        boolean[][] visited = new boolean[grid.length][grid.length];
        
        int result = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] ord = queue.poll();
                if(ord[0] == grid.length - 1 && ord[1] == grid.length - 1){
                    return result + 1;
                }
                if(visited[ord[0]][ord[1]]){
                    continue;
                }
                visited[ord[0]][ord[1]] = true;
                for(int[] direction : directions){
                    int row = direction[0] + ord[0];
                    int col = direction[1] + ord[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0){
                        queue.add(new int[]{row, col});
                    }
                    
                }
            }
            result++;
        }
        return -1;
    }
}