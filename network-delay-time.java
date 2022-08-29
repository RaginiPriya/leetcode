class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Map<Integer, Integer> dist = new HashMap<>();
        
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int[] time : times){
            List<int[]> next = map.get(time[0]);
            if(next == null){
                next = new ArrayList<>();
                map.put(time[0], next);
            }
            next.add(new int[]{time[1], time[2]});
        }
        
        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        
        while(true){
            int node = -1;
            int nodeDist = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++){
                if(!visited[i] && dist[i] < nodeDist){
                    nodeDist = dist[i];
                    node = i;
                }
            }
            if(node == -1){
                break;
            }
            visited[node] = true;
            List<int[]> list = map.get(node);
            if(list != null){
                for(int[] child : list){
                    dist[child[0]] = Math.min(dist[child[0]], nodeDist + child[1]);
                }
            }
            
        }
        
        int max = 0;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        
        return max;
        
    }
}