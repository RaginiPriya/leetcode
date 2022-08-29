class MedianFinder {
    
    // 6 10 2 6 5
    PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       min.offer(num);
       max.offer(min.poll());
       if(min.size() < max.size()){
         min.offer(max.poll());
       }
    }
    
    public double findMedian() {
       if(min.size() == max.size()){
         return (min.peek() + max.peek()) / 2.0;
       } else {
         return min.peek();
       } 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */