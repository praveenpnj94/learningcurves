//https://practice.geeksforgeeks.org/problems/word-boggle4143/1/?track=sp-graph&batchId=122

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int x = sc.nextInt();
            String[] dictionary = new String[x];
            for (int i = 0; i < x; i++) {
                dictionary[i] = sc.next();
            }

            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());

            char board[][] = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.next().charAt(0);
                }
            }

            Solution T = new Solution();
            String[] ans = T.wordBoggle(board, dictionary);

            if (ans.length == 0) System.out.println("-1");
            else {
                Arrays.sort(ans);
                for (int i = 0; i < ans.length; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }

            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String[] wordBoggle(char b[][], String[] d) {
        // Write your code here
        List < String > s = new ArrayList < > ();
        for (int i = 0; i < d.length; i++) {
            if (find(d[i], b))
                s.add(d[i]);
        }
        String arr[] = new String[s.size()];
        int k = 0;
        for (String g: s) {
            arr[k++] = g;
        }
        return arr;
    }

    public boolean find(String x, char b[][]) {

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == x.charAt(0)) {
                    if (cal(x, i, j, b, 0))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean cal(String x, int i, int j, char[][] b, int in ) {
        if ( in == x.length())
            return true;

        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length)
            return false;
        if (b[i][j] != x.charAt( in ))
            return false;

        char ch = b[i][j];
        b[i][j] = '$';
        if (cal(x, i - 1, j, b, in +1)) {
            b[i][j] = ch;
            return true;
        }
        if (cal(x, i + 1, j, b, in +1)) {
            b[i][j] = ch;
            return true;
        }
        if (cal(x, i, j - 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }
        if (cal(x, i, j + 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }
        if (cal(x, i - 1, j - 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }

        if (cal(x, i - 1, j + 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }

        if (cal(x, i + 1, j - 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }

        if (cal(x, i + 1, j + 1, b, in +1)) {
            b[i][j] = ch;
            return true;
        }

        b[i][j] = ch;
        return false;
    }
}