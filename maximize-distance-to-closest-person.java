class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int res = 0;
        int last = -1;
        
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                if(last == -1){
                    res = i;
                }
                else{
                    res = Math.max(res, (i - last) / 2);
                }
                last = i;
            }
        }
        return Math.max(res, seats.length - 1 - last);
        
    }
}