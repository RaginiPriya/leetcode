class Solution {
    
    // 2 3 3
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] extra = null;
        
        int[] parents = new int[edges.length + 1];
        
        for(int i = 1; i <= edges.length; i++){
            parents[i] = i;
        }
        
        for(int[] edge : edges){
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            if(parent1 == parent2){
                extra = edge;
            }
            else{
                parents[parent1] = parent2;
            }
        }
        
        return extra;
        
    }
    
    private int find(int[] parents, int val){
        if(parents[val] == val){
            return val;
        }
        return find(parents, parents[val]);
    }
}