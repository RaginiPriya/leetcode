class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        for(List<Integer> row : wall){
            int edgeIndex = 0;
            for(int i = 0; i < row.size(); i++){
                edgeIndex = edgeIndex + row.get(i);
                row.set(i, edgeIndex);
            }
        }
        
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            for(int i = 0; i < row.size() - 1; i++){
                int edgeIndex = row.get(i);
                Integer count = map.get(edgeIndex);
                int maxHere = 0;
                if(count != null){
                    map.put(edgeIndex, count + 1);
                    maxHere = count + 1;
                }
                else{
                    map.put(edgeIndex, 1);
                    maxHere = 1;
                }
                if(maxHere > result){
                    result = maxHere;
                }
            }
        }
        
        return wall.size() - result;
    }
}