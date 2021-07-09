//https://leetcode.com/problems/coin-change/
//https://www.youtube.com/watch?v=jgiZlGzXMBw&t=606s
//https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16

class Solution {
    // public int coinChange(int[] coins, int amount) {
    //     int[] dp = new int[amount+1];
    //     Arrays.fill(dp,amount+1);
    //     dp[0]=0;
    //     for(int coin:coins){
    //         for(int i=1;i<=amount;i++){
    //             if(i>=coin){
    //                 dp[i]=Math.min(dp[i],1+dp[i-coin]);
    //             }
    //         }
    //     }
    //     return dp[amount]>amount?-1:dp[amount];        
    // }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int j=0;j<=amount;j++){
            dp[0][j]= Integer.MAX_VALUE-1;
        }     
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<=amount;j++){
            dp[1][j]=j%coins[0]==0?j/coins[0]:Integer.MAX_VALUE-1;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
                
            }
        }
        return dp[n][amount]>amount?-1:dp[n][amount];
    }
}