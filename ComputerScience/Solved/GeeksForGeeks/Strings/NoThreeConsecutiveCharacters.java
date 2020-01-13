//https://www.geeksforgeeks.org/minimum-characters-that-are-to-be-inserted-such-that-no-three-consecutive-characters-are-same/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String word = br.readLine();
		    System.out.println(modifyString(word));
		}
	}
	public static int modifyString(String word){
	    char[] str = word.toCharArray();
        int cnt = 0; 
        int n = str.length;
        int i = 0; 
        while (i < n - 2)  
        { 
  
            // A character needs to be 
            // inserted after str[i + 1] 
            if (str[i] == str[i + 1] &&  
                str[i] == str[i + 2])  
            { 
                cnt++; 
                i = i + 2; 
            }  
              
            // Current three consecutive 
            // characters are not same 
            else 
            { 
                i++; 
            } 
        } 
        return cnt;
	}
}