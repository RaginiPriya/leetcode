class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        List<String> res = new ArrayList<>();
        
        if(s.length() == 0) {
        	res.add("");
        }
        
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(wordDict.contains(sub)){
                List<String> nexts = dfs(s.substring(i), wordDict, map);
                for(String next : nexts){
                    if(next.isEmpty()){
                        res.add(sub);
                    }
                    else{
                         res.add(sub + " " + next);
                    }
                   
                }
            }
        }
        map.put(s, res);
        return res;
    }
}