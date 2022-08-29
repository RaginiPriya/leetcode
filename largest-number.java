class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, (x, y) -> {
            String s1 = x + y;
            String s2 = y + x;
            return s2.compareTo(s1);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String num : arr){
            sb.append(num);
        }
        
        String res = sb.toString();
        if(res.charAt(0) == '0'){
            return "0";
        }
        
        return res;
    }
}