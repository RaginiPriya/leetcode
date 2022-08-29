class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map<Integer, Set<Integer>> stopToBusesMap = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++){
            for(int stop : routes[i]){
                Set<Integer> buses = stopToBusesMap.get(stop);
                if(buses == null){
                    buses = new HashSet<>();
                    stopToBusesMap.put(stop, buses);
                }
                buses.add(i);
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        Set<Integer> seen_stops = new HashSet<>();
        boolean[] seen_buses = new boolean[routes.length];
        seen_stops.add(source);
        
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int stop = queue.poll();
                if(stop == target){
                    return level;
                }
                Set<Integer> buses = stopToBusesMap.get(stop);
                for(int bus : buses){
                    if(seen_buses[bus]){
                        continue;
                    }
                    for(int bus_stop : routes[bus]){
                        if(!seen_stops.contains(bus_stop)){
                            seen_stops.add(bus_stop);
                            queue.add(bus_stop);
                        }
                    }
                    seen_buses[bus] = true;
                }
                
            }
            level++;
        }
        return -1;
    }
}