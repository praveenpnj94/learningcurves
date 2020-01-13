//https://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/


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
		    String word = br.readLine();
		    System.out.println(binaryString(word,n));
		}
	}
	public static int binaryString(String word, int n){
	    char[] wordArr = word.toCharArray();
        int m = 0; // Count of 1's in input string 
  
        // Traverse input string and count of 1's in it 
        for (int i = 0; i < n; i++)  
        { 
            if (wordArr[i] == '1') 
                m++; 
        } 
  
        // Return count of possible pairs among m 1's 
        return m * (m - 1) / 2;
	}
}