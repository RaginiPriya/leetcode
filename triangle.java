class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> map = new HashMap<>();
        return minimumTotal(triangle, 0, 0, map);
    }
    
    private int minimumTotal(List<List<Integer>> triangle, int row, int col, Map<String, Integer> map){
        if(row >= triangle.size()){
            return 0;
        }
        List<Integer> list = triangle.get(row);
        if(col >= list.size()){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(row).append(",").append(col);
        String key = sb.toString();
        
        Integer val = map.get(key);
        
        if(val != null){
            return val;
        }
        
        int result = Math.min(minimumTotal(triangle, row + 1, col, map), minimumTotal(triangle, row + 1, col + 1, map));
        
        result += list.get(col);
        
        map.put(key, result);
        
        return result;
        
    }
}