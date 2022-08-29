class Solution {
    public int maxVowels(String s, int k) {
        
        int left = 0;
        int right = 0;
        
        int max = 0;
        
        while(right < k){
            char c = s.charAt(right);
            if(isVowel(c)){
                max++;
            }
            right++;
        }
        
        int count = max;
        
        while(right < s.length()){
            if(isVowel(s.charAt(left))){
                count--;
            }
            left++;
            if(isVowel(s.charAt(right))){
                count++;
                max = Math.max(max, count);
            }
            right++;
        }
        
        return max;
    }
    
    private boolean isVowel(char c){
        return c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u';
    }
}