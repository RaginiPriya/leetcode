class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int l1 = rec1[0];
        int b1 = rec1[1];
        int r1 = rec1[2];
        int t1 = rec1[3];
        
        int l2 = rec2[0];
        int b2 = rec2[1];
        int r2 = rec2[2];
        int t2 = rec2[3];
        
        int width = Math.min(r1, r2) - Math.max(l1, l2);
        int height =  Math.min(t1, t2) - Math.max(b1, b2);
        
        return width > 0 && height > 0;
    }
}