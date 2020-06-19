//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
//https://www.youtube.com/watch?v=blUwDD6JYaE

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