//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//https://www.thealgorists.com/Algo/DynamicProgramming/StateMachine/StockTradingWithTransactionFee

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        
        int[] noStock = new int[n];
        int[] hasStock = new int[n];
        
        hasStock[0]=-prices[0];
        
        
//         int previousDayHasStockValue = 0;
//         int previousDayNoStockValue = 0;
        
//         int currDayHasStockValue = 0;
//         int currDayNoStockValue = 0;
        
        for(int i=1;i<n;i++){
            hasStock[i]=Math.max(hasStock[i-1],noStock[i-1]-prices[i]);
            noStock[i]=Math.max(noStock[i-1],hasStock[i-1]+prices[i]-fee);
        }
        
        return noStock[n-1];
    }
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        
//         int[] noStock = new int[n];
//         int[] hasStock = new int[n];
        
//         hasStock[0]=-prices[0];
        
        
        int previousDayHasStockValue = -prices[0];
        int previousDayNoStockValue = 0;
        
        int currDayHasStockValue = 0;
        int currDayNoStockValue = 0;
        
        for(int i=1;i<n;i++){
            currDayHasStockValue=Math.max(previousDayHasStockValue,previousDayNoStockValue-prices[i]);
            currDayNoStockValue=Math.max(previousDayNoStockValue,previousDayHasStockValue+prices[i]-fee);
            
            previousDayHasStockValue = currDayHasStockValue;
            previousDayNoStockValue = currDayNoStockValue;
            
        }
        
        return previousDayNoStockValue;
    }
}