//https://www.geeksforgeeks.org/swap-all-odd-and-even-bits/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    System.out.println(swap(Integer.parseInt(br.readLine())));
		}
	}
	
	public static int swap(int n){
	    int e = n & 0xAAAAAAAA;
	    int o = n & 0x55555555;
	    return (e>>1)|(o<<1);
	}
}