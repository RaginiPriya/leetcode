class Solution {
    
    int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};
    int born = 2;
    int died = 3;
    
    public void gameOfLife(int[][] board) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int live = count(board, i, j);
                if(board[i][j] == 0 && live == 3){
                    board[i][j] = born;
                }
                else if(board[i][j] == 1 && (live < 2 || live > 3)){
                    board[i][j] = died;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == born){
                    board[i][j] = 1;
                }
                else if(board[i][j] == died){
                    board[i][j] = 0;
                }
            }
        }
        
    }
    
    private int count(int[][] board, int row, int col){
        
        int live = 0;
        
        for(int[] direction : directions){
            int i = row + direction[0];
            int j = col + direction[1];
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
                continue;
            }
            if(board[i][j] == 1 || board[i][j] == died){
                live++;
            }
        }
        
        return live;
    }
}