class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        generate(0, 0, n, result, "");
        
        return result;
    }
    
    private void generate(int open, int close, int n, List<String> result, String temp){
        if(temp.length() == n * 2){
            result.add(temp);
            return;
        }
        
        if(open < n){
            generate(open + 1, close, n, result, temp + "(");
        }
        if(close < open){
            generate(open, close + 1, n, result, temp + ")");
        }
    }
}