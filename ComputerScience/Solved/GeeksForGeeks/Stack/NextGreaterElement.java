//https://www.geeksforgeeks.org/next-greater-element/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main (String[] args) {
		//code
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		while(tests-- > 0) {
		    int n = scanner.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++) {
		        arr[i] = scanner.nextInt();
		    }
		    printNGE(arr, n);
		}
	}
	
	public static void printNGE(int[] arr, int n) {
	    Stack<Integer> stk = new Stack<Integer>();
	    stk.push(arr[n-1]);
	    arr[n-1] = -1;
	    for(int i=n-2;i>=0;i--) {
	        while(!stk.isEmpty() && stk.peek()<=arr[i])
	            stk.pop();
	        int stkPush = arr[i];
	        arr[i] = stk.isEmpty() ? -1 : stk.peek();
	        stk.push(stkPush);
	    }
	    for(int i=0;i<n;i++) {
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	}
}