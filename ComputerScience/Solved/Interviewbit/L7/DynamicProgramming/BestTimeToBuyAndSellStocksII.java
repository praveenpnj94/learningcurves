//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        int profit=0;
        for(int i=1;i<n;i++){
            if(A[i]>A[i-1]){
                profit+=A[i]-A[i-1];
            }
        }
        return profit;
    }
}
