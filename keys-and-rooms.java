class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, visited, 0);
        
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        
        return true;
    }
    
    private void visit(List<List<Integer>> rooms, boolean[] visited, int index){
        if(visited[index]){
            return;
        }
        visited[index] = true;
        List<Integer> nexts = rooms.get(index);
        for(int next : nexts){
            visit(rooms, visited, next);
        }
    }
}