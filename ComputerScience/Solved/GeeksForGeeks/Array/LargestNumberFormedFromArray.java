//https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t --> 0){
	        int n = sc.nextInt();
	        Integer[] arr = new Integer[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        System.out.println(largestNumberFormed(arr,n));
	    }
	}
	public static String largestNumberFormed(Integer[] arr, int n){
	    Arrays.sort(arr, new MyComparator());
	    String s="";
	    for(Integer num:arr){
	        s+=num.toString();
	    }
	    return s;
	}
}
class MyComparator implements Comparator<Integer>{
    	    @Override
	        public int compare(Integer x, Integer y){
	            String s = x.toString()+y.toString();
	            String t = y.toString()+x.toString();
	            return t.compareTo(s);
	        }
}