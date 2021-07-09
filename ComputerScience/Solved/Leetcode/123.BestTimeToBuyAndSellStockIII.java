//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//https://www.thealgorists.com/Algo/DynamicProgramming/StateMachine/MaxProfitWithAtMostTwoStockTradingTransactions
//https://www.youtube.com/watch?v=0STXF9IXhnA&ab_channel=codebix

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) {
            return 0;
        }
        int[][] noStock = new int[days][2]; // noStock[i][j] denotes maximum profit achievable 
            // by the end of day i with (j + 1) transactions completed with no stock in 
            // hand at the end of day 1. j = 0 or 1, that way (j + 1) can be either 1 or 2
        int[][] hasStock = new int[days][2]; // hasStock[i][j] denotes maximum profit achievable 
            // by the end of day i with (j + 1) transactions completed with 1 stock in hand at the end
            // of day 1. j = 0 or 1, that way (j + 1) can be either 1 or 2
        
        //Base conditions
        // First day - 1 transaction
        hasStock[0][0] = -prices[0];
        noStock[0][0] = 0; 
        // First day - 2 transactions
        noStock[0][1] = 0; // On the end of first day we are in noStock state and already two transactions have been made.
            // This means we have purchased and sold as part of first transaction, and have again purchased and sold
            // as part of second transaction. Since all both the purchases and sales have been made at the same price
            // we have made zero profit. Net profit = 0
        hasStock[0][1] = -prices[0]; 
        
        for (int day = 1; day < days; day++) { 
            // 1 transaction by the end of day-th day
            hasStock[day][0] = Math.max(hasStock[day - 1][0], -prices[day]); // hasStock[i][0] cannot come from noStock[i - 1][0]. 
                // It has to come from noStock[i - 1][-1]. noStock[i - 1][-1] denotes 
                // noStock value with ZERO transaction till end of day (i - 1). 
                // noStock[i - 1][-1] is always 0, since there has been no transaction.  
                // hasStock[day][0] = noStock[day - 1][-1] - prices[day] = 0 - prices[day] = -prices[day]
            noStock[day][0] = Math.max(noStock[day - 1][0], hasStock[day - 1][0] + prices[day]);
            
            // 2 transactions by the end of day-th day
            hasStock[day][1] = Math.max(hasStock[day - 1][1], noStock[day - 1][0] - prices[day]);
            noStock[day][1] = Math.max(noStock[day - 1][1], hasStock[day - 1][1] + prices[day]);
        }
        
       return noStock[days - 1][1];
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int flag = 2;
        int count =2;
        int dp[][][] =  new int[n][flag][count];
        
        for(int[][] i :  dp)
        {
            for(int[] j : i)
            {
                Arrays.fill(j,-1);
            }
        }
        
        return back(dp ,prices, 0,0,count-1);
        
    }
    private int back(int[][][] dp , int[] prices,  int flag, int index, int count)
    {
        if(index>=prices.length || count<0)
            return 0;
        
        if(dp[index][flag][count]!=-1)
            return dp[index][flag][count];
        
        if(flag==1) //previously bought so now  i can sell or skip
        {
            dp[index][flag][count] =  Math.max(back(dp ,prices, 0, index+1,count-1)+prices[index],back(dp ,prices, flag, index+1,count));
        }
        else //previously sold so now can only buy/skip
            dp[index][flag][count] =  Math.max(back(dp ,prices, 1, index+1,count)-prices[index],back(dp ,prices, flag, index+1,count));
        
        return dp[index][flag][count];
    }
}


//https://www.youtube.com/watch?v=37s1_xBiqH0

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] prices) {
        int size = prices.length;
        if (size <= 1) return 0;
        
        int leftMin = prices[0];
        int rightMax = prices[size - 1];
        
        int[] leftProfits = new int[size];
        int[] rightProfits = new int[size];
        
        // construct the difirectional DP array
        for (int i = 1; i < size; i++) {
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - leftMin);
            leftMin = Math.min(leftMin, prices[i]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rightProfits[i] = Math.max(rightProfits[i + 1], rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }
    
        int maxProfit = 0;
        for (int i = 0; i < size; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i]);
        }
        
        return maxProfit;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
      int t1Cost = Integer.MAX_VALUE, 
          t2Cost = Integer.MAX_VALUE;
      int t1Profit = 0,
          t2Profit = 0;
  
      for (int price : prices) {
          // the maximum profit if only one transaction is allowed
          t1Cost = Math.min(t1Cost, price);
          t1Profit = Math.max(t1Profit, price - t1Cost);
          // reinvest the gained profit in the second transaction
          t2Cost = Math.min(t2Cost, price - t1Profit);
          t2Profit = Math.max(t2Profit, price - t2Cost);
      }
  
      return t2Profit;
    }
  }
