//https://www.geeksforgeeks.org/reverse-words-in-a-given-string/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String sen = br.readLine();
		    System.out.println(reverseWordsInString(sen));
		}
	}
	public static String reverseWordsInString(String s){
	    String[] words = s.split("\\.");
	    String res ="";
	    for(int i=words.length-1;i>0;i--){
	        res+=words[i]+".";
	    }
	    res=res+words[0];
	    return res;
	}
}