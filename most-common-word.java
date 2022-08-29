class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        int i = 0;
        
        String result = "";
        int max = 0;
        
        Set<String> set = new HashSet<>();
        for(int in = 0; in < banned.length; in++){
            set.add(banned[in]);
        }
        
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        while(i < paragraph.length()){
            char c = paragraph.charAt(i);
            
            if(Character.isLetter(c)){
                sb.append(c);
            }
            else{
                String s = sb.toString().toLowerCase();
                if(!s.equals("")){
                    sb = new StringBuilder();
                    if(!set.contains(s)){
                        Integer count = map.get(s);
                        if(count == null){
                            count = 0;
                        }
                        count++;
                        if(count > max){
                            result = s;
                            max = count;
                        }
                        map.put(s, count);
                    }
                }
                
            }
            i++;
        }
        
        String s = sb.toString().toLowerCase();
        if(!set.contains(s)){
            Integer count = map.get(s);
            if(count == null){
                count = 0;
            }
            count++;
            if(count > max){
                result = s;
                max = count;
            }
        }
        
        return result;
        
        
    }
}