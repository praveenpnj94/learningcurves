//https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0/?track=PC-W8-DP&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            System.out.println(optimalStrategy(a));
        }
    }
    public static int optimalStrategy(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    dp[i][j] = 0;
                else if ((j - i + 1) % 2 == 0) // users turn
                    dp[i][j] = Math.max(a[i] + dp[i+1][j], a[j] + dp[i][j-1]);
                else // opponents turn
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}