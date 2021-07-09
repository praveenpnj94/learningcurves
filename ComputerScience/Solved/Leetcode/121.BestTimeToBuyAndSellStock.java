//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://www.youtube.com/watch?v=mj7N8pLCJ6w
//https://www.thealgorists.com/Algo/DynamicProgramming/MaximumProfitWithAtMostOneStockTradingTransactionAllowed
//https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30&ab_channel=Pepcoding

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (prices == null || days < 2) {
            return 0;
        }
        int[] hasStock = new int[days]; // hasStock[i] = max profit we can have at the end of day i with
                                        // one stock in possession, following the transition relation in
                                        // the state machine diagram
        int[] noStock = new int[days]; // noStock[i] = max profit at the end of day i with no stock at hand
                                       // following the transition relation in the state machine diagram
        
        // Base Condition
        hasStock[0] = -prices[0]; // we need to have one stock in our possession mandatorily
        noStock[0] = 0; // on first day there is no stock to sell. So, noStock[0] means 
                // we did not make any transaction at all on the first day  
                // giving us 0 net profit
        
        for (int day = 1; day < days; day++) {
            hasStock[day] = Math.max(hasStock[day - 1], -prices[day]);
            noStock[day] = Math.max(noStock[day - 1], hasStock[day - 1] + prices[day]);
        }
        return noStock[days - 1];
    }
}