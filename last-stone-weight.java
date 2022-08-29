class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        for(int i = 0; i < stones.length; i++){
            queue.add(stones[i]);
        }
        
        while(queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();
            if(x == y){
                continue;
            }
            queue.add(x - y);
        }
        
        return queue.size() == 0 ? 0 : queue.poll();
    }
}