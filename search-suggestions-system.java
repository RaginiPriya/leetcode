class TrieNode {
    TrieNode[] children = new TrieNode[26];
    List<String> matches = new ArrayList<>();
}
class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        
        Arrays.sort(products);
        
        for(String product : products){
            TrieNode curr = root;
            for(char c : product.toCharArray()){
                int index = c - 'a';
                if(curr.children[index] == null){
                    curr.children[index] = new TrieNode();
                }
                if(curr.children[index].matches.size() < 3){
                    curr.children[index].matches.add(product);
                }
                curr = curr.children[index];
            }
        }
        
        TrieNode curr = root;
        
        for(char c : searchWord.toCharArray()){
            int index = c - 'a';
            List<String> list = new ArrayList<>();
            if(curr == null || curr.children[index] == null){
                result.add(list);
                curr = null;
            }
            else{
                for(String product : curr.children[index].matches){
                    list.add(product);
                }
                result.add(list);
                curr = curr.children[index];
            }
        }
        
        return result;
    }
}