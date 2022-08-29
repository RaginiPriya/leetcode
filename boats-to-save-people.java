class Solution {
    
    // 2 2 2 3 3
    
    public int numRescueBoats(int[] people, int limit) {
        
        int left = 0 ;
        int right = people.length - 1;
        
        int count = 0;
        Arrays.sort(people);
        
        while(left < right){
            if(people[left] + people[right] <= limit){
                left++;
            }

            right--;
            
            count++;
        }
        
        return left == right ? count + 1 : count;
    }
}