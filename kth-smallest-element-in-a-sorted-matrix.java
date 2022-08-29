// 1    5   9
// 10   11  13
// 12   13  15

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int index = 1;
        
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            
            if(count < k){
                left = mid + 1;
            }
            else{
                right = mid;
            }
            
        }
        
        return left;
        
        
    }
}