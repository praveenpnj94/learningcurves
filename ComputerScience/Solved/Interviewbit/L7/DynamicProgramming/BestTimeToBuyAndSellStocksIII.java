//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
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