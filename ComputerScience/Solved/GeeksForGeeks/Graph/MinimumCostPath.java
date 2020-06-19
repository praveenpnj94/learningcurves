//https://practice.geeksforgeeks.org/problems/minimum-cost-path/0/?track=PC-W7-GR&batchId=127


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class cell{
        int x,y,dist;
        cell(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int arr[][]=new int[n][n];
		    int dist[][]=new int[n][n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            arr[i][j]=sc.nextInt();
		            dist[i][j]=Integer.MAX_VALUE;
		        }
		    }
		    System.out.println(dijkstra(arr,dist,n));
		}
	}
	static int dijkstra(int arr[][],int dist[][],int n){
	    PriorityQueue<cell> q=new PriorityQueue<cell>(new Comparator<cell>(){
	        public int compare(cell a,cell b){
	            return a.dist-b.dist;
	        }
	    });
	    boolean visited[][]=new boolean[n][n];    
	    int r[]={-1,0,0,1};
	    int c[]={0,-1,1,0};
	    dist[0][0]=arr[0][0];
	    q.add(new cell(0,0,dist[0][0]));
	    visited[0][0]=true;
	    while(!q.isEmpty()){
	        cell temp=q.poll();
	        if(temp.x==n-1&&temp.y==n-1)
	        return dist[temp.x][temp.y];
	        for(int k=0;k<4;k++){
	            int row=temp.x+r[k];
	            int col=temp.y+c[k];
	            if(Valid(row,col,n)&&!visited[row][col]){
	                if(dist[row][col]>dist[temp.x][temp.y]+arr[row][col]){
	                dist[row][col]=dist[temp.x][temp.y]+arr[row][col];
	                q.add(new cell(row,col,dist[row][col]));
    	            }
    	        }
    	    }
    	}
    	return -1;
	}
	static boolean Valid(int row,int col,int n){
	    return row>=0&&row<n&&col>=0&&col<n;
	}
}