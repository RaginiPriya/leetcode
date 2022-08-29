class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> result = new ArrayList<>();
        Set<String> pre = new HashSet<>();
        
        Arrays.sort(words, (x, y) -> Integer.compare(x.length(), y.length()));
        
        for(String word : words){
            if(wordBreak(word, pre)){
                result.add(word);
            }
            pre.add(word);
        }
        return result;
                                   
    }
    
    private boolean wordBreak(String word, Set<String> dict){
        if(dict.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}