//https://www.geeksforgeeks.org/check-if-a-given-number-is-sparse-or-not/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(checkSparse(Integer.parseInt(br.readLine())));
		}
	}
	public static int checkSparse(int num){
	    if((num & (num >>1))>=1){
	        return 0;
	    }
	    return 1;
	}
}