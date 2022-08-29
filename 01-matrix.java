class Solution {
    
    // 0 1 0 1 1    0 1 0 1 2   0 1 0 1 1
    // 1 1 0 0 1    1 1 0 0 1   1 1 0 0 1
    // 0 0 0 1 0    0 0 0 1 0   0 0 0 1 0
    // 1 0 1 1 1    1 0 1 1 1   1 0 1 1 1
    // 1 0 0 0 1    1 0 0 0 1   1 0 0 0 1
    
    public int[][] updateMatrix(int[][] mat) {
        
        int max = mat.length + mat[0].length;
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    int top = max;
                    int left = max;
                    if(i != 0){
                        top = mat[i - 1][j];
                    }
                    if(j != 0){
                        left = mat[i][j - 1];
                    }
                    mat[i][j] = Math.min(left, top) + 1;                    
                }
            }
        }
        
        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                if(mat[i][j] > 0){
                    int bottom = max;
                    int right = max;
                    if(i != mat.length - 1){
                        bottom = mat[i + 1][j];
                    }
                    if(j != mat[0].length - 1){
                        right = mat[i][j + 1];
                    }
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
                }
                
            }
        }
        
        return mat;
        
    }
}