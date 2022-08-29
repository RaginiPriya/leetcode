class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<Integer> temp = new ArrayList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                temp.add(grid[i][j]);
            }
        }
        
        while(k > 0){
            temp.add(0, temp.remove(temp.size() - 1));
            k--;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        int index = 0;
        
        for(int i = 0; i < grid.length; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++){
                row.add(temp.get(index++));
            }
            result.add(row);
        }
        
        return result;
    }
}