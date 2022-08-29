class Solution {
    public String smallestSubsequence(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!seen[c - 'a']){
                seen[c - 'a'] = true;
                while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i){
                    seen[stack.pop() - 'a'] = false;
                }
                stack.push(c);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        
        return sb.toString();
    }
}