class Solution {
    
    // 0 -> 1
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] pre = new List[numCourses];
        int[] degree = new int[numCourses];
        
        for(int i = 0; i < pre.length; i++){
            pre[i] = new ArrayList<>();
        }
        
        for(int[] prereq : prerequisites){
            pre[prereq[1]].add(prereq[0]);
            degree[prereq[0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            for(int next : pre[course]){
                degree[next]--;
                if(degree[next] == 0){
                    queue.add(next);
                }
            }
        }
        
        return numCourses == 0;
    }
}