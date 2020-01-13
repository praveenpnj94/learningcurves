//https://www.geeksforgeeks.org/concatenated-string-uncommon-characters-two-strings/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String a = br.readLine();
		    String b = br.readLine();
		    System.out.println(removeAndConcatenate(a,b));
		}
	}
    public static String removeAndConcatenate(String s1, String s2) 
    { 
        // Result 
        String res = ""; 
        int i; 
  
        // creating a hashMap to add characters in string s2 
        HashMap<Character, Integer> m = new HashMap<Character, Integer>(); 
        for (i = 0; i < s2.length(); i++) 
            m.put(s2.charAt(i), 1); 
  
        // Find characters of s1 that are not 
        // present in s2 and append to result 
        for (i = 0; i < s1.length(); i++) 
            if (!m.containsKey(s1.charAt(i))) 
                res += s1.charAt(i); 
            else
                m.put(s1.charAt(i), 2); 
  
        // Find characters of s2 that are not 
        // present in s1. 
        for (i = 0; i < s2.length(); i++) 
            if (m.get(s2.charAt(i)) == 1) 
                res += s2.charAt(i); 
  
        return res.equals("")?"-1":res; 
    } 
}