//https://practice.geeksforgeeks.org/problems/positive-negative-pair/0/?track=PC-W3-H&batchId=127


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
public static void main (String[] args) {

	StringBuilder sb = new StringBuilder();
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	while(T-->0){
	    int N = in.nextInt();
	    int[] arr = new int [N];
	    for(int i = 0; i<N; i++)
	        arr[i] = in.nextInt();
	    sb.append(PositiveNegativePair(arr, N)+"\n");
	}
	System.out.print(sb);
}
public static String PositiveNegativePair(int arr[], int N){
    String str = "";
    TreeSet <Integer> ts = new TreeSet<Integer>();
    for(int num:arr){
        if(num!=0)
            ts.add(num);
    }
    for(Integer value: ts){
        if(value>0)
            return (str.isEmpty())?"0":str;
        if(ts.contains(-value))
            str =(-value)+" "+value+" "+str;
    }
    return "0";
}
}