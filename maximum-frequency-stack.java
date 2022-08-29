class FreqStack {
    
    Map<Integer, Integer> numFreqMap;
    Map<Integer, Stack<Integer>> freqNumsMap;
    int maxFreq = 0;

    public FreqStack() {
        numFreqMap = new HashMap<>();
        freqNumsMap = new HashMap<>();
    }
    
    public void push(int val) {
        Integer freq = numFreqMap.get(val);
        if(freq == null){
            freq = 0;
        }
        freq = freq + 1;
        numFreqMap.put(val, freq);
        Stack<Integer> nums = freqNumsMap.get(freq);
        if(nums == null){
            nums = new Stack<>();
            freqNumsMap.put(freq, nums);
        }
        maxFreq = Math.max(maxFreq, freq);
        nums.add(val);
    }
    
    public int pop() {
        int val = freqNumsMap.get(maxFreq).pop();
        numFreqMap.put(val, maxFreq - 1);
        if(freqNumsMap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */