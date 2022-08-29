class Solution {
    public int longestSubstring(String s, int k) {
        
        if(k < 2){
            return s.length();
        }
        
        return longest(s, k, 0, s.length() - 1);
    }
    
    private int longest(String s, int k, int start, int end){
        
        if(start > end){
            return 0;
        }
        
        int[] freq = new int[26];
        
        for(int i = start; i <= end; i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        boolean valid = true;
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0 && freq[i] < k){
                valid = false;
                break;
            }
        }
        
        if(valid){
            return end - start + 1;
        }
        
        int best = 0;
        
        for(int i = start; i <= end; i++){
            if(freq[s.charAt(i) - 'a'] < k){
                best = Math.max(best, longest(s, k, start, i - 1));
                start = i + 1;
            }
        }
        
        return Math.max(best, longest(s, k, start, end));
    }
}