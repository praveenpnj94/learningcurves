//https://practice.geeksforgeeks.org/problems/m-coloring-problem/0/?track=graph-interview&amp;batchId=117


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
class GFG {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        PrintWriter printWriter=new PrintWriter(System.out);
        int t=sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(),
                m=sc.nextInt(),
                e=sc.nextInt();
            int[][] g=new int[n][n];
            for (int i=0;i<e;i++) {
                int u=sc.nextInt()-1,
                    v=sc.nextInt()-1;
                g[u][v]=1;
                g[v][u]=1;
            }
            solve(g,m);
        }
    }
    static boolean isSafe(int[][] g, int[] color, int c, int v) {
        for(int i=0;i<g.length;i++)
            if((g[v][i]==1) && (c==color[i]))
                return false;
        return true;
    }
    static void solve(int[][] g, int m) {
        int[] color=new int[g.length];
        if(!solveUtil(g, color, m, 0))
            System.out.println("0");
        else
            System.out.println("1");
    }
    static boolean solveUtil(int[][] g, int[] color, int m, int v) {
        if(v==g.length)
            return true;
        for(int c=1;c<=m;c++) {
            if(isSafe(g, color, c, v)) {
                color[v]=c;
                if(solveUtil(g,color,m,v+1))
                    return true;
                color[v]=0;
            }
        }
        return false;
    }
}