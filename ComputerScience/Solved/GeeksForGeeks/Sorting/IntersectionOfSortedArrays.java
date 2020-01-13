//https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/



/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
		    String[] dim = br.readLine().split(" ");
		    int m = Integer.parseInt(dim[0]);
		    int n = Integer.parseInt(dim[1]);
		    String[] a = br.readLine().split(" ");
		    String[] b = br.readLine().split(" ");
		    intersectionOfArrays(a,b,m,n);
		    System.out.println();
		}
	}
	
	public static void intersectionOfArrays(String[] a, String[] b,int m,int n){
	    int size = m+n;
	    int i=0;
	    int j=0; 
	    while(i<m && j<n){
	        if(Integer.parseInt(a[i])<Integer.parseInt(b[j])){
	            i++;
	        }
	        else if(Integer.parseInt(a[i])>Integer.parseInt(b[j])){
	            j++;
	        }
	        else{
	            System.out.print(b[j]+" ");
	            j++;
	            i++;
	        }
	    }
	}
}