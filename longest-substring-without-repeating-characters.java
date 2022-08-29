class Solution {
    
    // 012
    // abcabcbb
    // l  r
    public int lengthOfLongestSubstring(String s) {
        
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        
        int max = 0;
        
        int left = 0;
        int right = 0;
        
        char[] sArr = s.toCharArray();
        while(right < sArr.length){
            char c = sArr[right];
            if(arr[c] >= 0){
                max = Math.max(max, right - left);
                left = Math.max(left, arr[c] + 1);
            }
            arr[c] = right++;
        }
        return Math.max(max, right - left);
    }
}