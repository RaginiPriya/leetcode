class Solution {
    
    // a b c c c c d d
    
    // a b 8-2+1
    
    // b 8-1+1
    public int longestPalindrome(String s) {
        
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        
        return (s.length() - (set.size() == 0 ? 0 : set.size() - 1));
    }
}