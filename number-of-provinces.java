class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length];
        
        int ans = 0;
        
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, i, visited);
                ans++;
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] isConnected, int index, boolean[] visited){
        if(visited[index]){
            return;
        }
        visited[index] = true;
        int[] nexts = isConnected[index];
        for(int i = 0; i < nexts.length; i++){
            if(i != index && nexts[i] == 1){
                dfs(isConnected, i, visited);
            }
        }
    }
}