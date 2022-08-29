class Solution {
    
    // 25525511135
    //            i   
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        restore(s, result, new int[4], 0, 0);
        return result;
        
    }
    
    private boolean restore(String s, List<String> result, int[] parts, int index, int start){
        if(index == 4 && start == s.length()){
            StringBuilder sb = new StringBuilder();
            for(int part : parts){
                sb.append(part).append(".");
            }
            result.add(sb.toString().substring(0, sb.length() - 1));
            return true;
        }
        if(index == 4 && start < s.length()){
            return false;
        }
        for(int i = 1; i <= 3 && start + i <= s.length(); i++){
            String ipPart = s.substring(start, start + i);
            if(ipPart.length() > 1 && ipPart.charAt(0) == '0'){
                return false;
            }
            int ip = Integer.valueOf(ipPart);
            if(ip > 255){
                return false;
            }
            parts[index] = ip;
            restore(s, result, parts, index + 1, start + i);
        }
        return false;
    }
}