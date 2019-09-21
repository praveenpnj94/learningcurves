//https://practice.geeksforgeeks.org/problems/pairs-of-prime-number/0/?track=PC-W1&batchId=127



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    printPrimeFactors(n);
		}
		
	}
	
	public static void printPrimeFactors(int n){
		boolean prime[] = new boolean[n+1]; 
		for(int i=0;i<n;i++) 
			prime[i] = true; 
		
		for(int p = 2; p*p <=n; p++) 
		{ 
			// If prime[p] is not changed, then it is a prime 
			if(prime[p] == true) 
			{ 
				// Update all multiples of p 
				for(int i = p*2; i <= n; i += p) 
					prime[i] = false; 
			} 
		} 
		
		// Print all prime numbers 
		for(int i = 2; i < n; i++) 
		{ 
		   for(int j =2 ;j<n;j++){
		       if(prime[i] == true && j*i<=n && prime[j]==true) {
                    System.out.print(i+ " "+j+ " ");
			}
		   }
		}
		System.out.println();
		
	    
	}
}