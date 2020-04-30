//https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] a = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000}; 
		while(t-->0){
		    int value = sc.nextInt();
		    printMinimumNoOfCoins(a,value);
		    System.out.println();
		}
	}
	public static void printMinimumNoOfCoins(int[] a , int value){
	    int n = a.length;
	    List<Integer> l = new ArrayList<Integer>();
	    for(int i=n-1;i>=0;i--){
	        while(value>=a[i]){
	            value=value-a[i];
	            l.add(a[i]);
	        }
	    }
	    for(int num:l){
	        System.out.print(num+" ");
	    }
	}
}