class Solution {
    public boolean halvesAreAlike(String s) {
        Character[] arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> vowels = Arrays.asList(arr);
        int left = 0;
        int right = 0;
        
        int j = s.length() / 2;
        
        for(int i = 0; i < j; i++){
            if(vowels.contains(s.charAt(i))){
                left++;
            }
        }
        
        for(int i = j; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                right++;
            }
        }
        
        if(left == right){
            return true;
        }
        return false;
        
    }
}