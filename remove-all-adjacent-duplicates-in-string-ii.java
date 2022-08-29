class Solution {
    
    // d,1 e,1 e,2 
    
    public String removeDuplicates(String s, int k) {
        
        Stack<Letterfreq> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            int freq = k - 1;
            if(!stack.isEmpty() && stack.peek().letter == c){
                if(stack.peek().freq == freq){
                    stack.pop();
                }
                else{
                    stack.peek().freq++;
                }
            }
            else{
                stack.push(new Letterfreq(c, 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(Letterfreq letterfreq : stack){
            for(int i = 0; i < letterfreq.freq; i++){
                sb.append(letterfreq.letter);
            }
            
        }
        return sb.toString();
    }
    
    class Letterfreq {
        char letter;
        int freq;
        Letterfreq(char letter, int freq){
            this.letter = letter;
            this.freq = freq;
        }
    }
}