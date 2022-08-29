class Solution {
    public String tictactoe(int[][] moves) {
        
        int[] aRow = new int[3];
        int[] bRow = new int[3];
        
        int[] aCol = new int[3];
        int[] bCol = new int[3];
        
        int aDiag1 = 0;
        int bDiag1 = 0;
        int aDiag2 = 0;
        int bDiag2 = 0;
        
        for(int i = 0; i < moves.length; i++){
            int row = moves[i][0];
            int col = moves[i][1];
            
            if(i % 2 == 0){
                if(++aRow[row] == 3
                  || ++aCol[col] == 3
                  || (row == col && ++aDiag1 == 3)
                  || (row + col == 2 && ++aDiag2 == 3)
                ){
                    return "A";
                }
            }
            else{
                if(++bRow[row] == 3
                  || ++bCol[col] == 3
                  || (row == col && ++bDiag1 == 3)
                  || (row + col == 2 && ++bDiag2 == 3)
                ){
                    return "B";
                }
            }
        }
        
        return moves.length == 9 ? "Draw" : "Pending";
    }
}