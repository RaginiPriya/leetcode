class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int extraConnections = 0;
        int components = 0;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < connections.length; i++){
            int p1 = findParent(parent, connections[i][0]);
            int p2 = findParent(parent, connections[i][1]);
            if(p1 == p2){
                extraConnections++;
            }
            else{
                parent[p1] = p2;
            }
        }
        
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                components++;
            }
        }
        
        // -1 because, to connect 2 components we need 1 connection. to connect 3 components, we need 2 connections. so to connect n components that are not connected yet, we need n-1 connections
        if(extraConnections >= components - 1){
            return components - 1;
        }
        
        return -1;
    }
    
    // we need to find top most parent
    private int findParent(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }
        parent[i] = findParent(parent, parent[i]);
        return parent[i];
    }
}