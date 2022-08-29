class MagicDictionary {
    
    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    
    public void buildDict(String[] dictionary) {

        for(String dict : dictionary){
            TrieNode node = root;
            for(int i = 0; i < dict.length(); i++){
                char c = dict.charAt(i);
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
    
    public boolean search(String searchWord) {
        TrieNode node = root;
        for(int i = 0; i < searchWord.length(); i++){
            char c = searchWord.charAt(i);
            for(char next = 'a'; next <= 'z'; next++){
                if(next == c || node.children[next - 'a'] == null){
                    continue;
                }
                if(helper(searchWord, node.children[next - 'a'], i + 1)){
                    return true;
                }
            }
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'] ;
        }
        return false;
    }
    
    private boolean helper(String searchWord, TrieNode node, int index){
        for(int i = index; i < searchWord.length(); i++){
            char c = searchWord.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */