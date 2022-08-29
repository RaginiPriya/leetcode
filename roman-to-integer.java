class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = (i == s.length() - 1) ? c1 : s.charAt(i + 1);
            
            int n1 = map.get(c1);
            int n2 = map.get(c2);
            
            if(n1 >= n2){
                num += n1;
            }
            
            else{
                num += n2 - n1;
                i++;
            }
        }
        
        return num;
    }
}