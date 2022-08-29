class Solution {
    
    // 0,2
    // 1,1
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        solve(result, 0, n, board);
        return result;
        
    }
    
    private void solve(List<List<String>> result, int row, int n, char[][] board){
        
        if(row == n){
            List<String> list = new ArrayList<>();
            for(char[] rowArr : board){
                String str = new String(rowArr);
                list.add(str);
            }
            result.add(list);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(valid(row, i, board)){
                board[row][i] = 'Q';
                solve(result, row + 1, n, board);
                board[row][i] = '.';
            }
        }
    }
    
    private boolean valid(int row, int col, char[][] board){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(Math.abs(row - i) == Math.abs(col - j) && board[i][j] == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }
}