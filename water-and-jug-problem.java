class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            StringBuilder sb = new StringBuilder();
            sb.append(arr[0]).append(",").append(arr[1]);
            String str = sb.toString();
            if(visited.contains(str)){
                continue;
            }
            visited.add(str);
            if(arr[0] + arr[1] == targetCapacity){
                return true;
            }
            queue.add(new int[]{0, arr[1]});
            queue.add(new int[]{arr[0], 0});
            queue.add(new int[]{jug1Capacity, arr[1]});
            queue.add(new int[]{arr[0], jug2Capacity});
            
            int x = Math.min(arr[0] + arr[1], jug1Capacity);
            int y = Math.max(arr[1] - (jug1Capacity - arr[0]), 0);
            queue.add(new int[]{x, y});
            
            x = Math.max(arr[0] - (jug2Capacity - arr[1]), 0);
            y = Math.min(arr[0] + arr[1], jug2Capacity);
            queue.add(new int[]{x, y});
        }
        
        return false;
    }
}