class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            // String s = new String(str);
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for(List<String> list : map.values()){
            result.add(list);
        }
        
        return result;
    }
}