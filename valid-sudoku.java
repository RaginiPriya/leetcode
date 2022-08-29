class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    board[i][j] = '.';
                    if(!valid(board, i, j, c)){
                        return false;
                    }
                    board[i][j] = c;
                }
            }
        }
        
        return true;
    }
    
    private boolean valid(char[][] board, int row, int col, char c){
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
        }
        
        int sqrt = 3;
        
        int rowS = row - (row % sqrt);
        int colS = col - (col % sqrt);
        
        for(int i = rowS; i < rowS + sqrt; i++){
            for(int j = colS; j < colS + sqrt; j++){
                if(board[i][j] == c){
                    return false;
                }
            }
        }
        
        return true;
    }
}