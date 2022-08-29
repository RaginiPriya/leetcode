class Solution {
    public int[] diStringMatch(String s) {
        
        int left = 0;
        int right = s.length();
        int[] res = new int[s.length() + 1];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I'){
                res[i] = left++;
            }
            else{
                res[i] = right--;
            }
        }
        res[s.length()] = left;
        return res;
    }
}