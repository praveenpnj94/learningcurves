//https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/


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
		    printBinary(n);
		}
	}
	public static void printBinary(int n){
	    for(int i=1;i<=n;i++){
	        System.out.print(Integer.toBinaryString(i)+" ");
	    }
	    System.out.println();
	}
	public static void generatePrintBinary(int n) 
    { 
        // Create an empty queue of strings 
        Queue<String> q = new LinkedList<String>(); 
          
        // Enqueue the first binary number 
        q.add("1"); 
          
        // This loops is like BFS of a tree with 1 as root 
        // 0 as left child and 1 as right child and so on 
        while(n-- > 0) 
        { 
            // print the front of queue 
            String s1 = q.peek(); 
            q.remove(); 
            System.out.println(s1); 
              
            // Store s1 before changing it 
            String s2 = s1; 
              
            // Append "0" to s1 and enqueue it 
            q.add(s1 + "0"); 
              
            // Append "1" to s2 and enqueue it. Note that s2 contains 
            // the previous front 
            q.add(s2 + "1"); 
        } 
    }
}