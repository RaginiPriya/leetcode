class Solution {
    
    // cbaebabacd
    //        l  r
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()){
            return res;
        }
        
        int[] arr = new int[26];
        int[] sArr = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            arr[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        while(right < p.length()){
            char c = s.charAt(right++);
            sArr[c - 'a']++;
        }
        
        while(right <= s.length()){
            boolean check = check(sArr, arr);
            if(check){
                res.add(left);
            }
            if(right == s.length()){
                break;
            }
            sArr[s.charAt(left) - 'a']--;
            left++;
            sArr[s.charAt(right++) - 'a']++;
            
        }
        
        return res;
    }
    
    private boolean check(int[] sArr, int[] arr){
        for(int i = 0; i < 26; i++){
            if(arr[i] > 0 && arr[i] != sArr[i]){
                return false;
            }
        }
        return true;
    }
}