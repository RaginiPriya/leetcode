class Solution {
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTree(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#'){
            return;
        }
        char c = board[i][j];
        if(node.next[c - 'a'] == null){
            return;
        }
        node = node.next[c - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);
        board[i][j] = c;
    }
    
    private TrieNode buildTree(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode p = root;
            for(char c : word.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null){
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}