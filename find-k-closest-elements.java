class Solution {
    
    // 1 3 5 7 9 11
    //       se m  e
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left = 0;
        int right = arr.length - k;
        
        while(left < right){
            int middle = left + (right - left) / 2;
            
            if(x - arr[middle] > arr[middle + k] - x){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = left; i < left + k; i++){
            list.add(arr[i]);
        }
        
        return list;
        
        
//         int index = binarySearch(arr, x, 0, arr.length - 1);
//         List<Integer> list = new ArrayList<>();
        
//         list.add(arr[index]);
//         int left = index - 1;
//         int right = index + 1;
        
//         boolean canAdd = true;
        
//         while(true){
//             if(list.size() < k && left >= 0){
//                 list.add(arr[left]);
//                 left--;
//             }
//             if(list.size() < k && right < arr.length){
//                 list.add(arr[right]);
//                 right++;
//             }
//             else{
//                 break;
//             }
//         }
//         list.sort((num1,num2) -> num1 - num2);
//         return list;
    }
    
//     private int binarySearch(int[] arr, int num, int start, int end){
        
//         if(start > end){
//             return start;
//         }
        
//         if(start == end && arr[start] == num){
//             return start;
//         }
//         else if(start == end && arr[start] != num){
//             return (start > 0 ? start - 1 : start);
//         }
//         else{
//             int middle = start + (end - start) / 2;
//             if(arr[middle] < num){
//                 return binarySearch(arr, num, middle + 1, end);
//             }
//             else if(arr[middle] > num){
//                 return binarySearch(arr, num, start, middle - 1);
//             }

//             return middle;
//         }
        
//     }
}