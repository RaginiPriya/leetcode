class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] result = new int[numCourses];
        List<Integer>[] pre = new List[numCourses];
        int[] degree = new int[numCourses];
        
        for(int i = 0; i < pre.length; i++){
            pre[i] = new ArrayList<>();
        }
        
        for(int[] prereq : prerequisites){
            pre[prereq[1]].add(prereq[0]);
            degree[prereq[0]]++;
        }
        
        int index = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 0){
                queue.add(i);
                result[index++] = i;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            numCourses--;
            for(int next : pre[course]){
                degree[next]--;
                if(degree[next] == 0){
                    queue.add(next);
                    result[index++] = next;
                }
            }
        }
        
        return numCourses == 0 ? result : new int[0];
    }
}