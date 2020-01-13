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
		    unionOfArrays(a,b,m,n);
		    System.out.println();
		}
	}
	
	public static void unionOfArrays(String[] a, String[] b,int m,int n){
	    int size = m+n;
	    String[] res = new String[size];
	    int k=0;
	    for(int i=0;i<m;i++){
	        res[k++]=a[i];
	    }
	    for(int j=0;j<n;j++){
	        res[k++]=b[j];
	    }
	    LinkedHashMap<String,Integer> lm = new LinkedHashMap<String,Integer>();
	    for(int l=0;l<size;l++){
	        if(lm.containsKey(res[l])){
	            int cnt = lm.get(res[l]);
	            lm.put(res[l],cnt+1);
	        }
	        else{
	            lm.put(res[l],1);
	        }
	    }
	    for(String num:lm.keySet()){
	        System.out.print(num+" ");
	    }
	}
}