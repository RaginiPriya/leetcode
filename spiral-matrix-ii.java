class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        
        int index = 1;
        
        while(index <= n * n){
            for(int i = colS; i <= colE; i++){
                result[rowS][i] = index++;
            }
            rowS++;
            for(int i = rowS; i <= rowE; i++){
                result[i][colE] = index++;
            }
            colE--;
            if(rowS <= rowE && colS <= colE){
                for(int i = colE; i >= colS; i--){
                    result[rowE][i] = index++;
                }
                rowE--;
                for(int i = rowE; i >= rowS; i--){
                    result[i][colS] = index++;
                }
                colS++;
            }
        }
        
        return result;
    }
}