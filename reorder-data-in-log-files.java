class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (x, y) -> {
            int firstSpace = x.indexOf(' ');
            int secondSpace = y.indexOf(' ');
            
            char c1 = x.charAt(firstSpace + 1);
            char c2 = y.charAt(secondSpace + 1);
            
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                int content = x.substring(firstSpace + 1).compareTo(y.substring(secondSpace + 1));
                if(content == 0){
                    content = x.substring(0, firstSpace).compareTo(y.substring(0, secondSpace));
                }
                return content;
            }
            if(!Character.isLetter(c1) && !Character.isLetter(c2)){
                return 0;
            }
            if(Character.isLetter(c1) && !Character.isLetter(c2)){
                return -1;
            }
            if(!Character.isLetter(c1) && Character.isLetter(c2)){
                return 1;
            }
            return 0;
        });
        
        return logs;
    }
}