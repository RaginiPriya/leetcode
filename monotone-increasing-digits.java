class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        String num = String.valueOf(n);
        char[] arr = num.toCharArray();
        int marker = arr.length;
        
        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i] < arr[i - 1]){
                arr[i - 1] -= 1;
                marker = i;
            }
        }
        
        for(int i = marker; i < arr.length; i++){
            arr[i] = '9';
        }
        
        return Integer.valueOf(new String(arr));
    }
}