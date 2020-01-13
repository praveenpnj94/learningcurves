/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s = br.readLine().trim();
		    System.out.println(removeDuplicates(s));
		}
	}
	
	public static String removeDuplicates(String s){
	    Stack<Character> st = new Stack<>();
	    String res="";
	    st.add(s.charAt(0));
	    res= res+Character.toString(s.charAt(0));
	    for(int i=1;i<s.length();i++){
	        char c= st.peek();
	        if(c!=s.charAt(i)){
	            res= res+Character.toString(s.charAt(i));
	            st.add(s.charAt(i));
	        }
	    }
	    return res;
	}
}