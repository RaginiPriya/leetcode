class Solution {
    public int strStr(String haystack, String needle) {
        
        int firstPointer = 0;
        int secondPointer = 0;
        int result = -1;
        
        if(needle.length() == 0){
            return 0;
        }
        
        while(firstPointer < haystack.length() && secondPointer < needle.length()){
            if(haystack.charAt(firstPointer) == needle.charAt(secondPointer)){
                if(result == -1){
                    result = firstPointer;
                }
                secondPointer++;
            }
            else{
                if(result != -1){
                    secondPointer = 0;
                    firstPointer = result;
                    result = -1;
                }
            }
            firstPointer++;
        }
        if(secondPointer < needle.length()){
            return -1;
        }
        return result;
    }
}