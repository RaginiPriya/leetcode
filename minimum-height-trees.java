class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 1){
            return Collections.singletonList(0);
        }
        
        List<Set<Integer>> connections = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            connections.add(new HashSet<>());
        }
        
        for(int[] edge : edges){
            connections.get(edge[0]).add(edge[1]);
            connections.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(connections.get(i).size() == 1){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                int neighbour = connections.get(leaf).iterator().next();
                connections.get(neighbour).remove(leaf);
                if(connections.get(neighbour).size() == 1){
                    newLeaves.add(neighbour);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}