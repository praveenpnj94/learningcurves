//https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    int[][] maze = new int[n][n];
		    for(int i=0;i<n;i++){
		        String[] s = br.readLine().trim().split(" ");
		        for(int j =0;j<n;j++){
		            maze[i][j] = Integer.parseInt(s[j]);
		        }
		    }
		    rateInMazeJumps(maze,n);
		    System.out.println();
		}
	}
	public static boolean rateInMazeJumps(int[][] maze,int n){
	    int[][] sol = new int[n][n];
	    if(rateInMazeJumpUtils(maze,0,0,n,sol)){
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                System.out.print(sol[i][j]+" ");
	            }
	            if(i<n-1){
                    System.out.println();	                
	            }
	            
	        }
	        return true;
	    }
	    else{
	        System.out.print("-1");
	        return false;
	    }
	    
	}
	public static boolean rateInMazeJumpUtils(int[][] maze,int x, int y,int n,int[][] sol){
	    if(x==n-1 && y==n-1){
	        sol[x][y]=1;
	        return true;
	    }
	    if(isSafe(maze,x,y,n)){
	        sol[x][y] = 1; 
	        for(int i=1;i<=maze[x][y];i++){
	            if(rateInMazeJumpUtils(maze,x,y+i,n,sol)){
	                return true;
	            }
	            if(rateInMazeJumpUtils(maze,x+i,y,n,sol)){
	                return true;
	            }
	        }
	        sol[x][y]=0;
	        return false;
	    }
	    return false;
	}
	public static boolean isSafe(int[][] maze,int x, int y,int n){
	    return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] != 0);
	}
}