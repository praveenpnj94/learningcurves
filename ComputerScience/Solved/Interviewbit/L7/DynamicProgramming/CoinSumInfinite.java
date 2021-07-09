//https://www.interviewbit.com/problems/coin-sum-infinite/

public class Solution {
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[][] dp = new int[n+1][B+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=B;j++){
                if(j>=A[i-1]){
                    dp[i][j]=(dp[i-1][j]+dp[i][j-A[i-1]])%1000007;
                }
                else{
                    dp[i][j]=(dp[i-1][j])%1000007;
                }
                
            }
        }
        
        return (dp[n][B]% 1000007);
    }
}
