//


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
		    System.out.println(checkParanthesis(word));
		}
	}
	public static String checkParanthesis(String word){
	    
	    Stack<Character> s = new Stack<Character>();
	    for(int i=0;i<word.length();i++){
	        if(word.charAt(i)=='('||word.charAt(i)=='{'||word.charAt(i)=='['){
	            s.push(word.charAt(i));
	        }
	        else{
	            char c = word.charAt(i);
	            if(!s.isEmpty()){
	            char p = s.peek();
	            if(match(c,p)){
	                s.pop();
	            }
	            else{
	                s.push(c);
	            } 
	            }
	            else{
	                s.push(c);
	            }
	        }
	    }
	    if(s.isEmpty()){
	        return "balanced";
	    }
	    else{
	        return "not balanced";
	    }
	}
	public static boolean match(char c, char p){
	    if(c==']' && p=='['){
	        return true;
	    }
	    else if(c=='}' && p=='{'){
	        return true;
	    }
	    else if(c==')' && p=='('){
	        return true;
	    }
	    return false;
	}
}