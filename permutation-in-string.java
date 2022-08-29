class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] s1arr = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            s1arr[c - 'a']++;
        }
        
        int[] s2arr = new int[26];
        
        int left = 0;
        int right = 0;
        
        while(right < s1.length()){
            char c = s2.charAt(right);
            s2arr[c - 'a']++;
            right++;
        }
        
        right--;
        
        while(right < s2.length()){
            if(compare(s1arr, s2arr)){
                return true;
            }
            char c = s2.charAt(left);
            left++;
            s2arr[c - 'a']--;
            right++;
            if(right < s2.length()){
                c = s2.charAt(right);
                s2arr[c - 'a']++;
            }
            
        }
        
        return false;
        
    }
    
    private boolean compare(int[] s1arr, int[] s2arr){
        for(int i = 0; i < s1arr.length; i++){
            if(s1arr[i] != s2arr[i]){
                return false;
            }
        }
        return true;
    }
}