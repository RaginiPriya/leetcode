class Solution {
    public int maxProfit(int k, int[] prices) {
        
        if(prices.length == 0){
            return 0;
        }
        
        int[] buy = new int[k + 1];
        int[] profit = new int[k + 1];
        
        Arrays.fill(buy, -prices[0]);
        
        for(int i = 0; i < prices.length; i++){
            for(int j = k; j > 0; j--){
                profit[j] = Math.max(profit[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], profit[j - 1] - prices[i]);
            }
        }
        
        return profit[k];
    }
}