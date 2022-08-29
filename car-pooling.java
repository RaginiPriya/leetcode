class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int[] trip : trips){
            Integer count = map.get(trip[1]);
            if(count == null){
                count = 0;
            }
            map.put(trip[1], count + trip[0]);
            count = map.get(trip[2]);
            if(count == null){
                count = 0;
            }
            map.put(trip[2], count - trip[0]);
        }
        
        int count = 0;
        
        for(int val : map.values()){
            count += val;
            if(count > capacity){
                return false;
            }
        }
        return true;
    }
}