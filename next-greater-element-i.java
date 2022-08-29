class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                    map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
            // if(nums2[i] > nums2[i + 1]){
            //     stack.push(nums2[i]);
            // }
            // else{
            //     map.put(nums2[i], nums2[i + 1]);
            //     while(!stack.isEmpty() && stack.peek() < nums2[i + 1]){
            //         map.put(stack.pop(), nums2[i + 1]);
            //     }
            // }
        }
        
        int[] result = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++){
            Integer val = map.get(nums1[i]);
            if(val == null){
                val = -1;
            }
            result[i] = val;
        }
        
        return result;
    }
}