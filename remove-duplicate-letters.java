class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] letters = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            letters[c - 'a']++;
        }
        
        boolean[] visited = new boolean[26];
        
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            letters[c - 'a']--;
            if(visited[c - 'a']){
                continue;
            }
            visited[c - 'a'] = true;
            while(!stack.isEmpty() && c < stack.peek() && letters[stack.peek() - 'a'] != 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
        }
        
        for(char c : stack){
            result.append(c);
        }
        
        return result.toString();
    }
}