class Solution {
    public String convert(String s, int numRows) {
        
        char[] arr = s.toCharArray();
        
        StringBuilder[] sbArr = new StringBuilder[numRows];
        
        for(int in = 0; in < numRows; in++){
            sbArr[in] = new StringBuilder();
        }
        
        int i = 0;
        
        while(i < arr.length) {
            for(int in = 0; in < numRows && i < arr.length; in++){
                sbArr[in].append(arr[i++]);
            }
            for(int in = numRows - 2; in >= 1 && i < arr.length; in--){
                sbArr[in].append(arr[i++]);
            }
        }
        
        for(int in = 1; in < numRows; in++){
            sbArr[0].append(sbArr[in]);
        }
        
        return sbArr[0].toString();
              
              
    }
}