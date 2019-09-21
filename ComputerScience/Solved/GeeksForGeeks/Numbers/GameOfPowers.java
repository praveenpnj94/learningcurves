//https://practice.geeksforgeeks.org/problems/game-of-powers/0/?track=PC-W1


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		while(t-->0){
		    String[] strings = br.readLine().split(" ");
                   int left = strings[0].charAt(strings[0].length()-2)-'0';
                   int right = strings[1].charAt(strings[1].length()-1)-'0';
                   int res = left*right;
                   String v = String.valueOf(res);
                   String m = String.valueOf(v.charAt(v.length()-1));
                   System.out.println(m+"1");
		}
	}
}