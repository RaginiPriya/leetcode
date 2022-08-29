class Solution {
    
    // 4, 5, 9
    // 4, 4, 8, 9, 9
    
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int first = 0;
        int second = 0;
        
        Set<Integer> set = new HashSet<>();
        
        while(first < nums1.length && second < nums2.length){
            if(nums1[first] == nums2[second]){
                int num = nums2[second];
                set.add(num);
                while(first < nums1.length && nums1[first] == num){
                    first++;
                }
                while(second < nums2.length && nums2[second] == num){
                    second++;
                }
            }
            else if(nums1[first] < nums2[second]){
                first++;
            }
            else{
                second++;
            }
        }
        
        int[] intersections = new int[set.size()];
        int i = 0;
        for(int num : set){
            intersections[i++] = num;
        }
        
        return intersections;
    }
}