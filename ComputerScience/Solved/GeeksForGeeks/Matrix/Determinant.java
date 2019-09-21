//https://www.geeksforgeeks.org/determinant-of-a-matrix/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     while(t-->0){
	         int n = sc.nextInt();
	         int[][] mat = new int[n][n];
	         for(int i = 0; i<n; i++){
	             for(int j=0; j<n; j++){
	                 mat[i][j] = sc.nextInt();
	             }
	         }
	         
	         System.out.println(detMat(mat, n));
	     }
    	
	 }
	 
	 public static long detMat(int[][] mat, int n){
	     if(n==1){
	         return mat[0][0];
	     }else if(n==2){
	         return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];
	     }
	     int temp[][] = new int[n-1][n-1];
	     long d = 0;
	     int sign = 1;
	     for(int i=0; i<n; i++){
	          int p =0;
	         for(int j=1; j<n; j++){
	             int q = 0;
	             for(int k=0; k<n; k++){
	                 if(k==i){
	                     continue;
	                 }
	                 temp[p][q++]= mat[j][k];
	             }
	             p++;
	         }
	         d+=sign*mat[0][i]*detMat(temp, n-1);
	         sign = -sign;
	     }
	     
	     return d;
	 }
}