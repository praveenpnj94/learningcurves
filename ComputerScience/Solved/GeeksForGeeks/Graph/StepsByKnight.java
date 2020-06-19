//https://practice.geeksforgeeks.org/problems/steps-by-knight/0/?track=PC-W7-GR&batchId=127
//https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/

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
		    int srcX = sc.nextInt();
		    int srcY = sc.nextInt();
		    int destX = sc.nextInt();
		    int destY = sc.nextInt();
		    int[][] a = new int[n][n];
		    System.out.println(bfs(a,n,srcX,srcY,destX,destY));
		}
	}
	public static int bfs(int[][] a,int n,int i,int j,int destX,int destY){
	    boolean[][] vis = new boolean[n+1][n+1];
	    Queue<Node> q = new LinkedList<>();
	    q.add(new Node(i,j,0));
	    vis[i][j]=true;
	    int[][] dim = {{-2,1},{2,1},{-1,2},{1,2},{-2,-1},{2,-1},{-1,-2},{1,-2}};
	    while(!q.isEmpty()){
	        Node t = q.poll();
	        int dist = t.dist;
	        if(t.x==destX && t.y == destY){
	            return t.dist;
	        }
	        for(int[] d:dim){
	            int row = t.x+d[0];
	            int col = t.y+d[1];
	            if(isValid(row,col,n) && !vis[row][col]){
	                vis[row][col]=true;
	                q.add(new Node(row,col,dist+1));
	            }
	        }
	    }
	    return -1;
	}
	public static boolean isValid(int row, int col, int n){
	    if(row<1||row>=n+1||col<1||col>=n+1){
	        return false;
	    }
	    return true;
	}
}
class Node{
    int x;
    int y;
    int dist;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}