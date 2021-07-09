//https://www.interviewbit.com/problems/minimum-difference-subsets/

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        
        int totalSum = 0;
        for(int num:A){
            totalSum+=num;
        }
        
        boolean[][] dp = new boolean[n+1][totalSum+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        
        for(int i =1;i<=n;i++){
            for(int j=1;j<=totalSum;j++){
                dp[i][j]=dp[i-1][j];
                if(A[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-A[i-1]];
                }
            }
        }
        int res= Integer.MAX_VALUE;
        
        for(int i=0;i<=totalSum;i++){
            if(dp[n][i]){
                int s2 =  totalSum-i;
                res=Math.min(res,Math.abs(i-s2));
            }
        }
        return res;
    }
}
