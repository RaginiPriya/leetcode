class Solution {
    
    //  s   s
    //  s       s
    //      s   s
    
    //  s       s
    //      s
    //  s       s
    
    public int removeStones(int[][] stones) {
        
        Set<String> visited = new HashSet<>();
        
        String index = "";
        
        int noOfIsland = 0;
        
        for(int i = 0; i < stones.length; i++){
            index = stones[i][0] + "," + stones[i][1];
            if(!visited.contains(index)){
                dfs(stones, i, visited);
                noOfIsland++;
            }
        }
        
        return stones.length - noOfIsland;
    }
    
    private void dfs(int[][] stones, int i, Set<String> visited){
        String index = stones[i][0] + "," + stones[i][1];
        if(visited.contains(index)){
            return;
        }
        visited.add(index);
        
        for(int j = 0; j < stones.length; j++){
            if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                dfs(stones, j, visited);
            }
        }
    }
}