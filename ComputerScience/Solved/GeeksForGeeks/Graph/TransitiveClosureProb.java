//https://practice.geeksforgeeks.org/problems/transitive-closure-of-a-graph/0/?track=graph-interview&batchId=117

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
		    int[][] graph = new int[n][n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            graph[i][j]=sc.nextInt();
		        }
		    }
		    int[][] tc =new int[n][n];
		    for(int i=0;i<n;i++){
		        dfs(i,i,tc,graph);
		    }
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            System.out.print(tc[i][j]+" ");
		        }
		    }
		    System.out.println();
		}
	}
	public static void dfs(int i, int j, int[][] tc,int[][] graph){
        tc[i][j]=1;
	    for(int n=0;n<graph.length;n++){
	       if(graph[j][n]==1){
	           if(tc[i][n]==0){
	               dfs(i,n,tc,graph);
	           }
	       }
	    }
	}
}