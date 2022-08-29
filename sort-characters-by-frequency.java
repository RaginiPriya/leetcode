class Solution {
    public String frequencySort(String s) {
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((x, y) -> {
            return y.getValue() - x.getValue();
        });
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Integer count = map.get(c);
            if(count == null){
                count = 0;
            }
            map.put(c, count + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            for(int i = 0; i < entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString();
    }
}