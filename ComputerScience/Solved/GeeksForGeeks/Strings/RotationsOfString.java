//https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String a = br.readLine();
		    String b = br.readLine();
		    System.out.println(checkRotation(a,b));
		}
	}
	public static int checkRotation(String a, String b){
	    if(a.length()!=b.length()){
	        return 0;
	    }
	    else{
	        return ((a+a).indexOf(b)!=-1)==true?1:0;
	    }
	}
}