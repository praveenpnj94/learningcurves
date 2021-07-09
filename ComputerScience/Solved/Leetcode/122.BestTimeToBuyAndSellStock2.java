//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
//https://www.youtube.com/watch?v=blUwDD6JYaE
//https://www.thealgorists.com/Algo/DynamicProgramming/MaxProfitWithUnlimitedStockTradingTransactions

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int profit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (prices == null || days < 2) { // if days < 2 net profit = 0 since we 
                // cannot sell. For selling you at least need 2 days since 
                // ou may not engage in multiple transactions at the 
                // same time (i.e., you must sell the stock before you buy again).
            return 0;
        }
        int[] noStock = new int[days];
        int[] hasStock = new int[days];
        
        // Base Condition
        noStock[0] = 0; // no stock at the end of first day means we did not do anything 
            // all day first day. We started with zero stock and 
            // we ended the day with zero stock. So profit = 0
        hasStock[0] = -prices[0]; // it is first day so we started with net profit = 0 and then we bought a stock, so at the end 
            // of first day profit = negative of prices[0]
        
        for (int day = 1; day < days; day++) {
            noStock[day] = Math.max(noStock[day - 1], hasStock[day - 1] + prices[day]);
            hasStock[day] = Math.max(hasStock[day - 1], noStock[day - 1] - prices[day]);
        }
        return noStock[days - 1];
    }
}