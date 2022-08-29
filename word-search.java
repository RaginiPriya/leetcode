class Solution {
    
    // A B C E
    // S F C S
    // A D E E
    
    // ABCB
    
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, word, visited, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, int i, int j, String word, boolean[][] visited, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return false;
        }
        
        char c = word.charAt(index);
        
        if(c != board[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        
        for(int[] direction : directions){
            if(exist(board, i + direction[0], j + direction[1], word, visited, index + 1)){
                return true;
            }
        }
        visited[i][j] = false;
        
        return false;
    }
}