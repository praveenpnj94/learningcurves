//https://www.youtube.com/watch?v=Z9XWbqxyn3E
//https://www.youtube.com/watch?v=6qMFjFC9YSc
//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/


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
		    System.out.println(uniquePaths(m,n));
		}
	}
	public static int uniquePaths(int m, int n){
	    int[][] res = new int[m][n];
	    Arrays.stream(res).forEach(a -> Arrays.fill(a, 1));
	    for(int i=1;i<m;i++){
	        for(int j=1;j<n;j++){
	            res[i][j]=res[i][j-1]+res[i-1][j];
	        }
	    }
	    return res[m-1][n-1];
	}
}