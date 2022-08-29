class Solution {
    public int maxProfit(int[] prices) {
        
        int buy1 = -prices[0];
        int buy2 = -prices[0];
        
        int profit1 = 0;
        int profit2 = 0;
        
        for(int i = 1; i < prices.length; i++){
            profit2 = Math.max(profit2, buy2 + prices[i]);
            buy2 = Math.max(buy2, profit1 - prices[i]);
            profit1 = Math.max(profit1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        
        return profit2;
        
    }
}