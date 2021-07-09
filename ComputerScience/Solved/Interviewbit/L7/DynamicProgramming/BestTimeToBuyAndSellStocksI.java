//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<n;i++){
            min=Math.min(min,A[i]);
            profit=Math.max(profit,A[i]-min);
        }
        return profit;
    }
    
}
