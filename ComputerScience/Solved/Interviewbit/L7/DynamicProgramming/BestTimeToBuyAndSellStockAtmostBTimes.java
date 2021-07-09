//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stock-atmost-b-times/
//https://www.youtube.com/watch?v=oDhu5uGq_ic&ab_channel=TusharRoy-CodingMadeSimple

public class Solution {
    
    public int solve(int[] prices, int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        if(K >= n/2) {
            int ans = 0;
            for(int i = 1; i < n; i++)  ans += Math.max(prices[i] - prices[i-1], 0);
            return ans;
        }
        int T[][] = new int[K+1][prices.length];
 
        for (int i = 1; i <= K; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[K][prices.length-1];
    }
}
