class SubsetSum {

    public int countSubsets(int[] num, int sum) {
      int n = num.length;
      int[][] dp = new int[n+1][sum + 1];
  
      // populate the sum=0 columns, as we will always have an empty set for zero sum
      for(int i=0; i <= n; i++)
        dp[i][0] = 1;
  
      // process all subsets for all sums
      for(int i=1; i <= num.length; i++) {
        for(int s=1; s <= sum; s++) {
          // exclude the number
          dp[i][s] = dp[i-1][s];
          // include the number, if it does not exceed the sum
          if(s >= num[i-1])
            dp[i][s] = dp[i-1][s]+ dp[i-1][s-num[i-1]];
        }
      }
  
      // the bottom-right corner will have our answer.
      return dp[num.length][sum];
    }
  
    public static void main(String[] args) {
      SubsetSum ss = new SubsetSum();
      int[] num = {1, 1, 2, 3};
      System.out.println(ss.countSubsets(num, 4));
      num = new int[]{1, 2, 7, 1, 5};
      System.out.println(ss.countSubsets(num, 9));
    }
  }
  