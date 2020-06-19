//https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0/?track=md-graph&batchId=144
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int[][] arr = new int[m][n];
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++){
		            arr[i][j] = sc.nextInt();
		        }
		    }
		    int destx = sc.nextInt();
		    int desty = sc.nextInt();
		    System.out.println(shortestPath(arr,destx,desty,m,n));
		}
	}
	
	public static int shortestPath(int[][] arr,int destx, int desty, int m, int n){
	    if(arr==null||arr.length==0){
	        return -1;
	    }
	    if(arr[0][0]!=1 || arr[destx][desty]!=1){
	        return -1;
	    }
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(new Node(0,0,0));
	    boolean[][] vis = new boolean[m][n];
	    vis[0][0] = true;
	    int[][] dim = {{-1,0},{1,0},{0,-1},{0,1}};
	    while(!q.isEmpty()){
	        Node p = q.poll();
	        int x = p.x;
	        int y = p.y;
	        int dist = p.dist;
	        if(x==destx && y==desty){
	            return dist;
	        }
	        for(int[] d:dim){
	            int nr = x + d[0];
	            int nc = y + d[1];
	            if(nr>=m||nc>=n||nr<0||nc<0){
	                continue;
	            }
	   	        if(!vis[nr][nc] && arr[nr][nc]==1){
	   	            vis[nr][nc]=true;
	   	            q.add(new Node(nr,nc,dist+1));
	            }
	        }
	    }
	    return -1;
	}
}
class Node{
    int x;
    int y;
    int dist;
    
    Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}