class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        int i = 0;
        
        while(i + 10 <= s.length()){
            String dna = s.substring(i, i + 10);
            Integer count = map.get(dna);
            if(count == null){
                count = 0;
            }
            if(count == 1){
                list.add(dna);
            }
            map.put(dna, count + 1);
            i++;
        }
        
        return list;
    }
}