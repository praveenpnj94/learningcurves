//https://practice.geeksforgeeks.org/problems/number-of-possible-squares/0/?track=PC-W1

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    Long n = Long.parseLong(br.readLine());
		    Long res = n*(n+1)*(2*n+1)/6;
		    System.out.println(res.toString());
		}
	}
}