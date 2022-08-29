class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> countMap = new HashMap<>();
        
        for(String word: words){
            Integer count = countMap.get(word);
            if(count == null){
                count = 0;
            }
            countMap.put(word, count + 1);
        }
        
        List<String> list = new ArrayList<>();
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((x, y) -> {
            if(x.getValue() == y.getValue()){
                return y.getKey().compareTo(x.getKey());
            }
            return x.getValue() - y.getValue();
        });
        
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            queue.add(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        
        for(int i = 0; i < k; i++){
            list.add(0, queue.poll().getKey());
        }
        
        return list;
    }
}