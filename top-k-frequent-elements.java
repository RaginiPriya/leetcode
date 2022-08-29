class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
        
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int num : nums){
//             Integer count = map.get(num);
//             if(count == null){
//                 count = 0;
//             }
//             map.put(num, count + 1);
//         }
        
//         PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> {
//             return x.getValue() - y.getValue();
//         });
        
//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             queue.add(entry);
//             if(queue.size() > k){
//                 queue.poll();
//             }
//         }
        
//         int[] res = new int[k];
        
//         for(int i = 0; i < k; i ++){
//             res[i] = queue.poll().getKey();
//         }
        
//         return res;
//     }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            Integer count = map.get(num);
            if(count == null){
                count = 0;
            }
            map.put(num, count + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getValue();
            if(bucket[key] == null){
                bucket[key] = new ArrayList<Integer>();
            }
            bucket[key].add(entry.getKey());
        }
        
        int[] res = new int[k];
        int index = 0;
        
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
            	for(int num : bucket[i]) {
            		if(k == 0) {
            			return res;
            		}
            		res[index++] = num;
            		k--;
            	}
            }
        }
        
        return res;
        
    }
}