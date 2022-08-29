class TimeMap {
    
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        TreeMap<Integer, String> valueMap = map.get(key);
        if(valueMap == null){
            valueMap = new TreeMap<>();
            map.put(key, valueMap);
        }
        valueMap.put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        
        TreeMap<Integer, String> valueMap = map.get(key);
        if(valueMap == null){
            return "";
        }
        Map.Entry<Integer, String> value = valueMap.floorEntry(timestamp);
        if(value == null){
            return "";
        }
        return value.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */