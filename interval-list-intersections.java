class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> list = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length){
            int[] first = firstList[i];
            int[] second = secondList[j];
            
            if(first[0] <= second[1] && second[0] <= first[1]){
                list.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            }
            
            if(first[1] <= second[1]){
                i++;
            }
            else{
                j++;
            }
            
            // if(first[1] >= second[0] && second[1] >= first[1]){
            //     list.add(new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])});
            //     if(first[1] < second[1]){
            //         i++;
            //     }
            //     else{
            //         j++;
            //     }
            // }
            // else if(first[0] <= second[1] && first[1] >= second[1]){
            //     list.add(new int[]{Math.min(first[0], second[1]), second[1]});
            //     if(first[1] > second[1]){
            //         j++;
            //     }
            //     else{
            //         i++;
            //     }
            // }
            // else{
            //     if(first[1] < second[1]){
            //         i++;
            //     }
            //     else{
            //         j++;
            //     }
            // }
        }
        
        int[][] res = new int[list.size()][];
        for(int index = 0; index < list.size(); index++){
            res[index] = list.get(index);
        }
        
        return res;
    }
}