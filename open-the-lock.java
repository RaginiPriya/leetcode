class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int level = 0;
        
        begin.add("0000");
        end.add(target);
        
        while(!begin.isEmpty() && !end.isEmpty()){
            if(end.size() < begin.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            
            Set<String> temp = new HashSet<>();
            for(String str : begin){
                if(visited.contains(str)){
                    continue;
                }
                if(end.contains(str)){
                    return level;
                }
                visited.add(str);
                for(int i = 0; i < 4; i++){
                    char c = str.charAt(i);
                    String s1 = str.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + str.substring(i + 1);
                    String s2 = str.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + str.substring(i + 1);
                    temp.add(s1);
                    temp.add(s2);
                }
            }
            level++;
            begin = end;
            end = temp;
        }
        
        return -1;
    }
}