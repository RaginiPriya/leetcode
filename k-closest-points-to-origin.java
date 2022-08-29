class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
//         Arrays.sort(points, (x, y) -> Integer.compare(x[0] * x[0] + x[1] * x[1], y[0] * y[0] + y[1] * y[1]));
        
//         int[][] res = new int[k][];
        
//         for(int i = 0; i < res.length; i++){
//             res[i] = points[i];
//         }
        
//         return res;
        
//         PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> Integer.compare(y[0] * y[0] + y[1] * y[1], x[0] * x[0] + x[1] * x[1]));
        
//         for(int i = 0; i < points.length; i++){
//             queue.add(points[i]);
//             if(queue.size() > k){
//                 queue.poll();
//             }
//         }
        
//         int[][] res = new int[k][];
//         for(int i = k - 1; i >= 0; i--){
//             res[i] = queue.poll();
//         }
        
//         return res;
        
        int left = 0;
        int right = points.length - 1;
        
        while(left <= right){
            int pivot = quicksort(points, left, right);
            if(pivot == k){
                break;
            }
            else if(pivot < k){
                left = pivot + 1;
            }
            else{
                right = pivot - 1;
            }
        }
        
        int[][] res = new int[k][];
        for(int i = 0; i < k; i++){
            res[i] = points[i];
        }
        return res;
    }
    
    private int quicksort(int[][] points, int left, int right){
        int pivot = right;
        int index = left;
        while(index < pivot){
            if(compare(points[index], points[pivot]) < 0){
                swap(points, left, index);
                left++;
            }
            index++;
        }
        swap(points, left, pivot);
        return left;
    }
    
    private void swap(int[][] points, int left, int index){
        int[] temp = points[left];
        points[left] = points[index];
        points[index] = temp;
    }
    
    private int compare(int[] x, int[] y){
        return Integer.compare(x[0] * x[0] + x[1] * x[1], y[0] * y[0] + y[1] * y[1]);
    }
}