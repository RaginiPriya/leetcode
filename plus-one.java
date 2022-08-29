class Solution {
    public int[] plusOne(int[] digits) {
        
        int num = digits[digits.length - 1] + 1;
        int carry = 0;
        
        if(num == 10){
            digits[digits.length - 1] = 0;
            carry = 1;
        }
        else{
            digits[digits.length - 1] = num;
            return digits;
        }
        
        int i = digits.length - 2;
        while(carry == 1 && i >= 0){
            digits[i] = digits[i] + 1;
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            }
            else{
                carry = 0;
                break;
            }
            i--;
        }
        
        if(carry == 1 && i < 0){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        
        return digits;
    }
}