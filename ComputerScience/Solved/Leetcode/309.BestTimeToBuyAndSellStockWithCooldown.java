//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//https://www.youtube.com/watch?v=4wNXkhAky3s&ab_channel=TECHDOSE
//https://www.youtube.com/watch?v=N-zlfQJWbYE&ab_channel=codebix
//https://www.thealgorists.com/Algo/DynamicProgramming/StateMachine/StockTradingWithCooldown

class Solution {
    private int maxProfit(int i, int buyOrSell, int[] prices, HashMap<String, Integer> hm) {
        if (i >= prices.length) 
            return 0;

        String key = i + "codebix" + buyOrSell;
        if(hm.containsKey(key))
            return hm.get(key);
        int x = 0; 
        if (buyOrSell == 0) {
            int buy   =  maxProfit(i + 1, 1, prices, hm) - prices[i];
            int noBuy =  maxProfit(i + 1, 0, prices, hm); 
            x = Math.max(buy, noBuy);
         } else {
            int sell   = maxProfit(i + 2, 0, prices, hm) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices, hm);
            x = Math.max(sell, noSell);
        }
        hm.put(key, x);
        return x;
    }
    
    public int maxProfit(int[] prices) {
        HashMap<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, hm);
    }
}

class StockProblems {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[] noStock = new int[len];
        int[] hasStock = new int[len];
        int[] justSold = new int[len];
        
        // bases cases
        hasStock[0] = -prices[0]; // if we acquire a stock on first day, then we will 
                    // have negative prices[0] as profit, i.e, no profit at 
                    // all in fact loss of amount equal to prices[0]
        noStock[0] = 0; // basically being in noStock state on first day means no transaction at all
                    // which means doing nothing on first day which means 0 net profit
        justSold[0] = Integer.MIN_VALUE; // selling on first day is not possible.
                    // since we are optiming for max profit
                    // we will mark this as Integer.MIN_VALUE 
                    // to show that this state is impossible on first day
        
        for (int day = 1; day < len; day++) {
            // now just put the state machine DP relations we have designed
            noStock[day] = Math.max(noStock[day - 1], justSold[day - 1]); 
            hasStock[day] = Math.max(noStock[day - 1] - prices[day], hasStock[day - 1]); 
            justSold[day] = hasStock[day - 1] + prices[day];                 
        }
        

        return Math.max(noStock[len - 1], justSold[len - 1]);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int previousDayNoStockValue = 0; // int[] noStock = new int[len];
        int previousDayHasStockValue = 0; // int[] hasStock = new int[len];
        int previousDayJustSoldValue = 0; // int[] justSold = new int[len];
        
        // bases cases
        previousDayHasStockValue = -prices[0]; // hasStock[0] = -prices[0];
        previousDayNoStockValue = 0; // noStock[0] = 0;
        previousDayJustSoldValue = Integer.MIN_VALUE; // justSold[0] = Integer.MIN_VALUE; 
        
        
        int currentDayHasStockValue = 0;
        int currentDayJustSoldValue = 0;
        int currentDayNoStockValue = 0;

        for (int day = 1; day < len; day++) {   
            /*
            noStock[day] = Math.max(noStock[day - 1], justSold[day - 1]); 
            hasStock[day] = Math.max(noStock[day - 1] - prices[day], hasStock[day - 1]); 
            justSold[day] = hasStock[day - 1] + prices[day]; 
            */
            currentDayNoStockValue = Math.max(previousDayNoStockValue, previousDayJustSoldValue); 
            currentDayHasStockValue = Math.max(previousDayNoStockValue - prices[day], previousDayHasStockValue); 
            currentDayJustSoldValue = previousDayHasStockValue + prices[day];    
            
            previousDayHasStockValue = currentDayHasStockValue;
            previousDayNoStockValue = currentDayNoStockValue;
            previousDayJustSoldValue = currentDayJustSoldValue;
        }
        

        return Math.max(previousDayNoStockValue, previousDayJustSoldValue);
        
    }
}