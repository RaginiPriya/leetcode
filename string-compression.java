class Solution {
    public int compress(char[] chars) {
        
        int index = 0;
        int in = 0;
        
        while(index < chars.length){
            char c = chars[index];
            int count = 0;
            
            while(index < chars.length && chars[index] == c){
                index++;
                count++;
            }
            
            chars[in++] = c;
            if(count != 1){
                String countStr = String.valueOf(count);
                for(int i = 0; i < countStr.length(); i++){
                    chars[in++] = countStr.charAt(i);
                }
            }
            
        }
        
        return in;
    }
}