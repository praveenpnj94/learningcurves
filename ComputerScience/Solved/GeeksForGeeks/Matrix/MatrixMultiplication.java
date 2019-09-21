//https://practice.geeksforgeeks.org/problems/multiply-the-matrices/0/?track=PC-W2-M&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            String d1[] = br.readLine().split(" ");
            String d1Array[] = br.readLine().split(" ");
            int r1 = Integer.parseInt(d1[0]);
            int c1 = Integer.parseInt(d1[1]);
            int[][] a = new int[r1][c1];
            int d1ArrayIndex = 0;
            for(int i = 0;i<r1;i++){
                for(int j=0;j<c1;j++){
                    a[i][j] = Integer.parseInt(d1Array[d1ArrayIndex]);
                    d1ArrayIndex++;
                }
            }
            String d2[] = br.readLine().split(" ");
            String d2Array[] = br.readLine().split(" ");
            int r2 = Integer.parseInt(d2[0]);
            int c2 = Integer.parseInt(d2[1]);
            int[][] b = new int[r2][c2];
            int d2ArrayIndex = 0;
            for(int i = 0;i<r2;i++){
                for(int j=0;j<c2;j++){
                    b[i][j] = Integer.parseInt(d2Array[d2ArrayIndex]);
                    d2ArrayIndex++;
                }
            }
            if(c1==r2){
                int[][] c = new int[r1][c2];
             for(int i = 0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    c[i][j]=0;
                    for(int k = 0;k<c1;k++){
                    c[i][j] += a[i][k]*b[k][j];
                    }
                }
            }
            printMatrix(c,r1,c2);
            System.out.println();
            }
            else{
                System.out.println("-1");
            }

        }
	 }
	 public static void printMatrix(int[][] a,int m,int n){
             for(int i = 0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(a[i][j]+" ");
                }
            }	     
	 }
}