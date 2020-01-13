/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(evaluatePostfix(br.readLine().trim()));
		}
	}
	public static int evaluatePostfix(String s){
	    Stack<Integer> st = new Stack<>();
	    for(int i=0;i<s.length();i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            st.push(Integer.parseInt(String.valueOf(c)));
	        }
	        else{
	            int o2 = st.pop();
	            int o1 = st.pop();
	            st.push(getResult(o1,o2,c));
	        }
	    }
	    return st.peek();
	}
	public static int getResult(int o1,int o2,char c){
	    if(c=='/'){
	        return o1/o2;
	    }
	   	    if(c=='*'){
	        return o1*o2;
	    }
	    	    if(c=='-'){
	        return o1-o2;
	    }
	    	    if(c=='+'){
	        return o1+o2;
	    }
	    return 0;
	}
}