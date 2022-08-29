class Solution {
    
    int[] parent = new int[26];
    
    public boolean equationsPossible(String[] equations) {
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(String str : equations){
            if(str.charAt(1) == '='){
                parent[find(str.charAt(0) - 'a')] = find(str.charAt(3) - 'a');
            }
        }
        
        for(String str : equations){
            if(str.charAt(1) == '!'){
                if(find(str.charAt(0) - 'a') == find(str.charAt(3) - 'a')){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int find(int letter){
        if(letter == parent[letter]){
            return letter;
        }
        return find(parent[letter]);
    }
}