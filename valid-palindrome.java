class Solution {
    public boolean isPalindrome(String s) {
        
        int firstPointer = 0;
        int secondPointer = s.length() - 1;
        
        while(firstPointer <= secondPointer){
            
            if(Character.isWhitespace(s.charAt(firstPointer))) {
                firstPointer++;
            }
            else if(!Character.isLetter(s.charAt(firstPointer)) && !Character.isDigit(s.charAt(firstPointer))) {
                firstPointer++;
            }
            else if(Character.isWhitespace(s.charAt(secondPointer))){
                secondPointer--;
            }
            
            else if(!Character.isLetter(s.charAt(secondPointer)) && !Character.isDigit(s.charAt(secondPointer))) {
                secondPointer--;
            }
            
            else if(Character.toUpperCase(s.charAt(firstPointer)) != Character.toUpperCase(s.charAt(secondPointer))){
                return false;
            }
            else{
                firstPointer++;
                secondPointer--;
            }

        }
        
        return true;
        
        
    }
}