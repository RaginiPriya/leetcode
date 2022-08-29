class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        allPaths(graph, result, 0, temp);
        return result;
    }
    
    private void allPaths(int[][] graph, List<List<Integer>> result, int index, List<Integer> temp){
        
        if(index == graph.length - 1){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        int[] nexts = graph[index];
        
        for(int next : nexts){
            temp.add(next);
            allPaths(graph, result, next, temp);
            temp.remove(temp.size() - 1);
        }
    }
}