class Solution {
    public String minWindow(String s, String t) {
        
        int[] map = new int[128];
        
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        
        int left = 0;
        int right = 0;
        int count = t.length();
        int start = 0;
        int length = Integer.MAX_VALUE;
        
        while(right < s.length()){
            char c = s.charAt(right);
            map[c]--;
            if(map[c] >= 0){
                count--;
            }
            right++;
            while(count == 0){
                if(length > right - left){
                    length = right - left;
                    start = left;
                }              
                char leftC = s.charAt(left);
                map[leftC]++;
                if(map[leftC] > 0){
                    count++;
                }
                left++;
            }
        }
        
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}