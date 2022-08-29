class Solution {
    
    TrieNode root = new TrieNode();
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        String[] words = sentence.split(" ");
        
        for(String dict : dictionary){
            TrieNode node = root;
            for(int i = 0; i < dict.length(); i++){
                char c = dict.charAt(i);
                if(node.links[c - 'a'] == null){
                    node.links[c - 'a'] = new TrieNode();
                }
                node = node.links[c - 'a'];
            }
            node.word = dict;
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            // String replace = "";
            TrieNode node = root;
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(node.links[c - 'a'] == null || node.word != null){
                    break;
                }
                else{
                    node = node.links[c - 'a'];
                }
            }
            if(node.word != null) {
            	result.append(node.word);
            }
            else{
                result.append(word);
            }
            if(i < words.length - 1){
                result.append(" ");
            }
        }

        return result.toString();
    }
    
    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;
    }
}