//https://leetcode.com/problems/longest-common-subsequence/
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1Arr = text1.toCharArray();
        char[] t2Arr = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(t1Arr[i-1]==t2Arr[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
        
    }
}