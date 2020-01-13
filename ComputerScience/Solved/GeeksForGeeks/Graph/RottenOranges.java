//https://www.youtube.com/watch?v=3hF3hP1MlUM&list=PLpO3gASfJEIJ4tnnYUX6vm8OhR92iGM7J&index=12

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int r = sc.nextInt();
		    int c = sc.nextInt();
		    int[][] mat = new int[r][c];
		    for(int i=0;i<r;i++){
		        for(int j=0;j<c;j++){
		            mat[i][j]= sc.nextInt();
		        }
		    }
		    System.out.println(rottenOranges(mat,r,c));
		}
	}
	public static int rottenOranges(int[][] mat, int r, int c){
	    Queue<Pair> q = new LinkedList<>();
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(mat[i][j]==2){
	                q.add(new Pair(i,j));
	            }
	        }
	    }
	    q.add(null);
	    int ans = 0;
	    while(!q.isEmpty()){
	        boolean flag = false;
	        while(q.peek()!=null){
	            Pair temp = q.peek();
	            if(isValid(temp.i+1,temp.j,r,c) && (mat[temp.i+1][temp.j]==1)){
	                if(!flag){
	                    flag = true;
	                    ans++;
	                }
	                mat[temp.i+1][temp.j]=2;
	                q.add(new Pair(temp.i+1,temp.j));
	            }
	            if(isValid(temp.i-1,temp.j,r,c) && (mat[temp.i-1][temp.j]==1)){
	                if(!flag){
	                    flag = true;
	                    ans++;
	                }
	                mat[temp.i-1][temp.j]=2;
	                q.add(new Pair(temp.i-1,temp.j));
	            }
	            if(isValid(temp.i,temp.j+1,r,c) && (mat[temp.i][temp.j+1]==1)){
	                if(!flag){
	                    flag = true;
	                    ans++;
	                }
	                mat[temp.i][temp.j+1]=2;
	                q.add(new Pair(temp.i,temp.j+1));
	            }
	            if(isValid(temp.i,temp.j-1,r,c) && (mat[temp.i][temp.j-1]==1)){
	                if(!flag){
	                    flag = true;
	                    ans++;
	                }
	                mat[temp.i][temp.j-1]=2;
	                q.add(new Pair(temp.i,temp.j-1));
	            }
	            q.poll();
	        }
	        q.poll();
	        if(!q.isEmpty()){
	            q.add(null);
	        }
	    }
	    for(int i=0;i<r;i++){
	        for(int j=0;j<c;j++){
	            if(mat[i][j]==1){
	                ans=-1;
	                break;
	            }
	        }
	    }
	    return ans;
	}
	public static boolean isValid(int x,int y,int r,int c){
	    if(x<0||y<0||x>=r||y>=c){
	        return false;
	    }
	    return true;
	}
}
class Pair{
    int i=0;
    int j=0;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}