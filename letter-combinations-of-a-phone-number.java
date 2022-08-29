class Solution {
    
    // 2
    // abc
    // a
    
    // 3
    // def
    
    
    public List<String> letterCombinations(String digits) {
                
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        
        if(digits.equals("")){
            return result;
        }
        
        letterCombinations(arr, result, new StringBuilder(), digits, 0);
        return result;
    }
    
    private void letterCombinations(String[] arr, List<String> result, StringBuilder temp, String digits, int start){
        if(start == digits.length()){
            result.add(temp.toString());
            return;
        }
        
        char c = digits.charAt(start);
        String str = arr[c - '0'];
        for(int index = 0; index < str.length(); index++){
            temp.append(str.charAt(index));
            letterCombinations(arr, result, temp, digits, start + 1);
            temp.setLength(temp.length() - 1);
        }
    }
}