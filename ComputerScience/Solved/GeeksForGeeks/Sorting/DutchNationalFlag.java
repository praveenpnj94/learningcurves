//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
//https://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/

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
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    sort(a,n);
		}
	}
	public static void dutchFlagSort(String[] a, int n){
	    int zeroCount = 0;
	    int oneCount = 0;
	    int twoCount = 0;
	    for(int i=0;i<n;i++){
	        if(a[i].equals("0")){
	            zeroCount++;
	        }
	 	    else if(a[i].equals("1")){
	            oneCount++;
	        }
	 	    else if(a[i].equals("2")){
	            twoCount++;
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int i=0;i<zeroCount;i++){
	        sb.append("0 ");
	    }
	    for(int i=0;i<oneCount;i++){
	        sb.append("1 ");
	    }
	    for(int i=0;i<twoCount;i++){
	        sb.append("2 ");
	    }
	    System.out.println(sb);
	}
	
	public static void sort(int[] a, int n){
	    int low =0;
	    int mid =0;
	    int high = n-1;
	    while(mid<=high){
	        switch(a[mid]){
	            case 0:
	                int temp = a[low];
	                a[low] =a[mid];
	                a[mid] = temp;
	                low++;
	                mid++;
	                break;
	           case 1:
	               mid++;
	               break;
	           case 2:
	               	int tem = a[mid];
	                a[mid] = a[high];
	                a[high] = tem;
	                high--;
	                break;
	        }
	    }
	    for(int i=0;i<n;i++){
	        System.out.print(a[i]+" ");
	    }
	    System.out.println();
	}
}