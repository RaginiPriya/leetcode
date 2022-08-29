class Solution {
    public int maxRepOpt1(String text) {
        
        int[] letterCount = new int[26];
        
        List<LetterLength> list = new ArrayList<>();
        
        letterCount[text.charAt(0) - 'a']++;
        int left = 0;
        char c = text.charAt(0);
        int i = 0;
        
        for(i = 1; i < text.length(); i++){
            letterCount[text.charAt(i) - 'a']++;
            if(text.charAt(i) != c){
                LetterLength ll = new LetterLength(c, left, i - 1);
                list.add(ll);
                c = text.charAt(i);
                left = i;
            }
        }
        LetterLength ll2 = new LetterLength(c, left, i - 1);
        list.add(ll2);
        
        //case1
        int maxLength = 0;
        
        for(LetterLength letterLength : list){
            int count = letterLength.end - letterLength.start + 1;
            if(count < letterCount[letterLength.c - 'a']){
                count++;
            }
            maxLength = Math.max(maxLength, count);
        }
        
        //case2
        for(i = 1; i < list.size() - 1; i++){
            LetterLength before = list.get(i - 1);
            LetterLength l = list.get(i);
            LetterLength after = list.get(i + 1);
            
            if(before.c == after.c && l.end - l.start == 0){
                int beforeLength = before.end - before.start + 1;
                int afterLength = after.end - after.start + 1;
                maxLength = Math.max(maxLength, Math.min(beforeLength + afterLength + 1, letterCount[before.c - 'a']));
            }
        }
        return maxLength;
    }
    
    static class LetterLength {
        char c;
        int start;
        int end;
        
        LetterLength(char c, int start, int end){
            this.c = c;
            this.start = start;
            this.end = end;
        }
    }
}