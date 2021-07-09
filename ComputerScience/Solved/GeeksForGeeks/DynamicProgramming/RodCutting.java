//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/


/*package whatever //do not write package name here */

class RodCutting {

	public int solveRodCutting(int[] lengths, int[] prices, int n) {
	  int N = lengths.length;
	  int dp[][] = new int[N+1][n + 1];
		  
		  // Fill dp[] using above recursive formula
		  for(int i = 1; i <= N; i++){
			  for(int j = 1; j <= n; j++){
				  if(lengths[i-1] <= j){
					  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-lengths[i-1]] + 
								  prices[i-1]);
				  }
				  else{
					  dp[i][j]=dp[i-1][j];
				  }
			  }
		  }
		  return dp[N][n];
	}
  
	public static void main(String[] args) {
	  RodCutting rc = new RodCutting();
	  int[] lengths = {1, 2, 3, 4, 5};
	  int[] prices = {2, 6, 7, 10, 13};
	  int maxProfit = rc.solveRodCutting(lengths, prices, 5);
	  System.out.println(maxProfit);
	}
  }
  