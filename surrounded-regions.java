class Solution {
    
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void solve(char[][] board) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        // first row
        for(int i = 0; i < board[0].length; i++){
            if(!visited[0][i] && board[0][i] == 'O'){
                dfs(board, visited, 0, i);
            }
        }
        
        // last row
        for(int i = 0; i < board[0].length; i++){
            if(!visited[board.length - 1][i] && board[board.length - 1][i] == 'O'){
                dfs(board, visited, board.length - 1, i);
            }
        }
        
        // first col
        for(int i = 0; i < board.length; i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(board, visited, i, 0);
            }
        }
        
        // last col
        for(int i = 0; i < board.length; i++){
            if(!visited[i][board[0].length - 1] && board[i][board[0].length - 1] == 'O'){
                dfs(board, visited, i, board[0].length - 1);
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
             
             
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'R';
        visited[i][j] = true;
        for(int[] direction : directions){
            dfs(board, visited, i + direction[0], j + direction[1]);
        }
    }
}