class Solution {
    
    // 1 0 1 4 1 4 1 2 3
    
    // type1=1
    // type2=0
    // count1=2
    // count2=1
    // total=3
    
    public int totalFruit(int[] fruits) {
        
        int type1 = 0;
        int type2 = 0;
        
        int curr = 0;
        int count2 = 0;
        
        int total = 0;
        
        for(int i = 0; i < fruits.length; i++){
            curr = fruits[i] == type1 || fruits[i] == type2 ? curr + 1 : count2 + 1;
            count2 = type2 == fruits[i] ? count2 + 1 : 1;
            if(type2 != fruits[i]){
                type1 = type2;
                type2 = fruits[i];
            }
            total = Math.max(total, curr);
            // if(fruits[i] == type1){
            //     count1++;
            //     type1 = type2;
            //     type2 = fruits[i];
            //     int temp = count1;
            //     count1 = count2;
            //     count2 = temp;
            // }
            // else if(fruits[i] == type2){
            //     count2++;
            // }
            // else if(type1 == -1){
            //     type1 = fruits[i];
            //     count1++;
            // }
            // else if(type2 == -1){
            //     type2 = fruits[i];
            //     count2++;
            // }
            // else{
            //     total = Math.max(total, count1 + count2);
            //     type1 = type2;
            //     count1 = count2;
            //     type2 = fruits[i];
            //     count2 = 1;
            // }
        }
        
        return total;
    }
}