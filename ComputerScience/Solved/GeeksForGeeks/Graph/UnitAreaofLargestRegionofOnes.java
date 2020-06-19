//https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s/0/?track=PC-W7-GR&batchId=127
//https://www.youtube.com/watch?v=W8VuDt0eb5c
//https://www.youtube.com/watch?v=ag2OJPOl5Ug


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int maxArea;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int[][] arr = new int[n][m];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            arr[i][j]=sc.nextInt();
		        }
		    }
		    System.out.println(maxAreaOfIsland(arr));
		}
	}
    public static int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }
    
    public static int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1)
            +AreaOfIsland(grid, i+1, j+1) + AreaOfIsland(grid, i-1, j-1) + AreaOfIsland(grid, i+1, j-1) + AreaOfIsland(grid, i-1, j+1);
        }
        return 0;
    }
	
}
class GFG {
    static int area;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            int ans=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==1){
                        area = 0;
                        ans=Math.max(ans,dfs(arr,i,j,n,m));
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static int dfs(int[][] arr,int i, int j, int n, int m){
        if(i<0||i>=n||j<0||j>=m||arr[i][j]==0){
            return 0;
        }
        arr[i][j]=0;
        area++;
        dfs(arr,i,j-1,n,m);
        dfs(arr,i,j+1,n,m);
        dfs(arr,i-1,j,n,m);
        dfs(arr,i+1,j,n,m);
        dfs(arr,i-1,j-1,n,m);
        dfs(arr,i+1,j+1,n,m);
        dfs(arr,i-1,j+1,n,m);
        dfs(arr,i+1,j-1,n,m);
        return area;
    }
}