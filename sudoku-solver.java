class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
                
    }
    
    private boolean solve(char[][] board){
        boolean found = false;
        int row = -1;
        int col = -1;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    found = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(found) {
            	break;
            }
        }
        
        if(!found){
            return true;
        }
        
        for(char i = '1'; i <= board.length + '0'; i++){
            if(valid(row, col, board, i)){
                board[row][col] = i;
                if(solve(board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean valid(int row, int col, char[][] board, char c){
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == c){
                return false;
            }
            if(board[i][col] == c){
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
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