//https://www.youtube.com/watch?v=jgiZlGzXMBw
//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem/ChangeMakingProblem.java
//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

/*
  Coin Change - LeetCode: https://leetcode.com/problems/coin-change
  All credit for code goes to user @elmirap who wrote the solution
  section to this problem: https://leetcode.com/problems/coin-change/solution/
  The video to explain this code is here: https://www.youtube.com/watch?v=jgiZlGzXMBw
*/

/*
  The Top Down Approach
  This code passes all Leetcode test cases as of Jan. 10 2019
  Runtime: 53 ms
*/
class Geeks
{
    //Complete this function
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        long minimumNumberOfCoinsRequired[]=new long[value+1];
        //The above array holds the minimum number of coins for every amount from 0 to value
        Arrays.fill(minimumNumberOfCoinsRequired,Integer.MAX_VALUE);
        //We fill all array with inifinty as intially we need infinite coins to make the value
        minimumNumberOfCoinsRequired[0]=0;
        for(int coin:coins)//Iterating over each coin
        {
            for(int i=1;i<value+1;i++)
            {
                if(i>=coin)//No use in checking for values that are smaller than the current coin
                {
                    //Your code here
                    /*
                    The minimum number of coins required to make current i value can be found
                    by taking seeeing which is minimum : 
                    (current coins required to form i value)
                    or
                    (1+ coins required to form i-coin value)
                    */
                   minimumNumberOfCoinsRequired[i]=Math.min(minimumNumberOfCoinsRequired[i],1+minimumNumberOfCoinsRequired[i-coin]);
                }
            }
        }
        return minimumNumberOfCoinsRequired[value];
    }
}
public class CoinChangeTopDown {

  public int coinChange(int[] coins, int amount) {    
    
    if (amount < 1) {
      return 0;
    }

    return coinChange(coins, amount, new int[amount + 1]);
  }

  private int coinChange(int[] coins, int remainder, int[] dp) {
  
    /*
      Minimum coins to make change for a negative amount is -1.
      This is just a base case we arbitrarily define.
    */
    if (remainder < 0) {
      return -1;
    }
  
    /*
      The minimum coins needed to make change for 0 is always 0
      coins no matter what coins we have.
    */
    if (remainder == 0) {
      return 0;
    }

    // We already have an answer cached. Return it.
    if (dp[remainder] != 0) {
      return dp[remainder];
    }

    /*
      No answer yet. Try each coin as the last coin in the change that
      we make for the amount
    */
    int minimum = Integer.MAX_VALUE;
    for (int coin : coins) {
      int changeResult = coinChange(coins, remainder - coin, dp);

      /*
        If making change was possible (changeResult >= 0) and 
        the change result beats our present minimum, add one to
        that smallest value
        
        We accept that coin as the last coin in our change making
        sequence up to this point since it minimizes the coins we
        need
      */
      if (changeResult >= 0 && changeResult < minimum) {
        minimum = 1 + changeResult;
      }
    }

    /*
      If no answer is found (minimum == Integer.MAX_VALUE) then the
      sub problem answer is just arbitrarily made to be -1, otherwise
      the sub problem's answer is "minimum"
    */
    dp[remainder] = (minimum == Integer.MAX_VALUE) ? -1 : minimum;

    // Return the sub problem's answer
    return dp[remainder];
  }

}

/*
  The Bottom Up Approach
  This code passes all Leetcode test cases as of Jan. 10 2019
  Runtime: 31 ms
*/

public class CoinChangeBottomUp {

  public int coinChange(int[] coins, int amount) {

    // We use this to fill the dp table with default values
    int max = amount + 1;

    // This table will store the answer to our sub problems
    int[] dp = new int[amount + 1];

    // Initialize the dp table
    Arrays.fill(dp, max);  

    /*
      The answer to making change with minimum coins for 0
      will always be 0 coins no matter what the coins we are
      given are
    */
    dp[0] = 0;

    // Solve every subproblem from 1 to amount
    for (int i = 1; i <= amount; i++) {
      // For each coin we are given
      for (int j = 0; j < coins.length; j++) {
        // If it is less than or equal to the sub problem amount
        if (coins[j] <= i) {
          // Try it. See if it gives us a more optimal solution
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    /*
      dp[amount] has our answer. If we do not have an answer then dp[amount]
      will be amount + 1 and hence dp[amount] > amount will be true. We then
      return -1.
      Otherwise, dp[amount] holds the answer
    */
    return dp[amount] > amount ? -1 : dp[amount];
  }

}