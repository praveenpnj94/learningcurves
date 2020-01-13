//https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
class Max{
    int val= Integer.MIN_VALUE;
}
class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<arr.length;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(maxCountSmallerOnRight(a,n));
		}
	}
	
	public static int maxCountSmallerOnRight(int[] arr , int n){
	    int count = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int index = n - 1; index >= 0; --index) {
            set.add(arr[index]);
            count = Math.max(count, set.headSet(arr[index]).size());
        }
        return count;
	}
}