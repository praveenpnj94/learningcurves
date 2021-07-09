//https://leetcode.com/problems/coin-change-2/
//https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
//https://www.youtube.com/watch?v=jaNZ83Q3QGc&feature=youtu.be

class Solution {
    //     public int change(int amount, int[] coins) {
    //         int[] dp = new int[amount + 1];
    //         dp[0] = 1;
    
    //         for (int coin: coins) {
    //             for (int x = 1; x < amount + 1; ++x) {
    //                 if (x >= coin) {
    //                     dp[x] += dp[x - coin];
    //                 }
    //             }
    //         }
    //         return dp[amount];
    //     }
        
    public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n+1][amount + 1];
            for(int i=0;i<=n;i++){
                dp[i][0]=1;
            }
            for (int i=1;i<=n;i++) {
                for (int j = 1; j <= amount; j++) {
                    if (coins[i-1] <= j) {
                        dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][amount];
        }
    }