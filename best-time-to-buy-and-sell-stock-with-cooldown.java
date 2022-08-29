class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = -prices[0];
        int profit = 0;
        int pre = 0;
        
        for(int i = 1; i < prices.length; i++){
            
            int temp = profit;
            
            profit = Math.max(profit, buy + prices[i]);
            buy = Math.max(buy, pre - prices[i]);
            pre = temp;
            
        }
        
        return profit;
        
    }
}