class Solution {
    
    // 2 3 1 1 4
    
    // jumps=2
    // currEnd=4
    // curFarthest=4
    
    public int jump(int[] A) {
	    int jumps = 0, curEnd = 0, curFarthest = 0;
	    for (int i = 0; i < A.length - 1; i++) {
		    curFarthest = Math.max(curFarthest, i + A[i]);
		    if (i == curEnd) {
			    jumps++;
			    curEnd = curFarthest;
                if(curEnd >= A.length){
                    break;
                }
		    }
	    }
	return jumps;
}
}