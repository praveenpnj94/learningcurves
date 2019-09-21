//https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    towerOfHanoi(n,'1','3','2');
		    System.out.println((int)Math.pow(2,n)-1);
		}
	}
	public static void towerOfHanoi(int n,char from,char to,char aux){
	    if(n==1){
	        System.out.println("move disk 1 from rod "+from+" to rod "+to);
	        return;
	    }
	    towerOfHanoi(n-1,from,aux,to);
	    System.out.println("move disk "+n+" from rod "+from+" to rod "+to);
	    towerOfHanoi(n-1,aux,to,from);
	}
	
}