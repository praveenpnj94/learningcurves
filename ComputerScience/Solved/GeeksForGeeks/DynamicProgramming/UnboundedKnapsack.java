//https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][] = new int[N+1][W + 1];
		
		// Fill dp[] using above recursive formula
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= W; j++){
				if(wt[i-1] <= j){
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-wt[i-1]] + 
								val[i-1]);
				}
				else{
				    dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[N][W];
    }
}
