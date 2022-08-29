class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[] result = new int[rowLength * colLength];
        
        int row = 0;
        int col = 0;
        
        for(int i = 0; i < result.length; i++){
            result[i] = mat[row][col];
            
            if((row + col) % 2 == 0){
                if(col == colLength - 1){
                    row++;
                }
                else if(row == 0){
                    col++;
                }
                else{
                    row--;
                    col++;
                }
            }
            
            else{
                if(row == rowLength - 1){
                    col++;
                }
                else if(col == 0){
                    row++;
                }
                else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}