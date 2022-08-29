class Solution {
    
    // -1 -1    4 3    
    // -1 3     1 2
    
    int length;
    int[][] boardArr;
    
    public int snakesAndLadders(int[][] board) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        length = board.length;
        boolean[] visited = new boolean[length * length + 1];
        queue.add(1);
        int level = 1;
        boardArr = board;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int in = 0; in < size; in++){
                int cell = queue.poll();
                if(visited[cell]){
                    continue;
                }
                visited[cell] = true;
                
                for(int i = 1; i <= 6; i++){
                    if(cell + i <= length * length){
                        // int next = cell + i;
                        // int[] pos = numToPos(next);
                        // if (board[pos[0]][pos[1]] > 0) {
                        //     next = board[pos[0]][pos[1]];
                        // }
                        int next = getCell(cell + i);
                        if(next == length * length){
                            return level;
                        }
                        queue.add(next);
                    }
                }
            }
            level++;
            
        }
        return -1;
    }
    
//     // 3 -> [5][2]
    private int getCell(int cell){
        int tempRow = (cell - 1) / length; // 3 -1 / 6 = 2 / 6 = 0
        int tempCol = (cell - 1) % length; // 3 -1 % 6 = 2 % 6 = 2
        
        int row = length - tempRow - 1;
        int col = (tempRow % 2 == 0) ? tempCol : length - tempCol - 1;
        
        if(boardArr[row][col] >= 0){
            return boardArr[row][col];
        }
        
        return cell;
    }
    
    private int[] numToPos(int target) {
        int row = (target - 1) / length, col = (target - 1) % length;
        int x = length - 1 - row, y = row % 2 == 0 ? col : length - 1 - col;
        return new int[]{x, y};
    }
}