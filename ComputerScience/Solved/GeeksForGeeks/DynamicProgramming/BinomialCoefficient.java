//https://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/
//https://www.geeksforgeeks.org/binomial-coefficient-dp-9/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int r = sc.nextInt();
		    System.out.println(nCr(n,r).mod(new BigInteger("1000000007")));
		}
	}
	
	public static BigInteger nCr(long n, long k){
        if(k>n)
            return new BigInteger("0");
        
        long z=Math.min(n-k,k);
        BigInteger c=new BigInteger("1");
        for(long i=0;i<z;i++){
            c=c.multiply(new BigInteger(""+(n-i)));
            c=c.divide(new BigInteger(""+(i+1)));
        }
        return c;
    }
}


// A Dynamic Programming based solution that uses table C[][] to 
// calculate the Binomial Coefficient 

class BinomialCoefficient 
{ 
	// Returns value of Binomial Coefficient C(n, k) 
	static int binomialCoeff(int n, int k) 
	{ 
	int C[][] = new int[n+1][k+1]; 
	int i, j; 
	
		// Calculate value of Binomial Coefficient in bottom up manner 
	for (i = 0; i <= n; i++) 
	{ 
		for (j = 0; j <= min(i, k); j++) 
		{ 
			// Base Cases 
			if (j == 0 || j == i) 
				C[i][j] = 1; 
	
			// Calculate value using previously stored values 
			else
				C[i][j] = C[i-1][j-1] + C[i-1][j]; 
		} 
	} 
	
	return C[n][k]; 
	} 

	// A utility function to return minimum of two integers 
	static int min(int a, int b) 
	{ 
	return (a<b)? a: b; 
	} 

	/* Driver program to test above function*/
	public static void main(String args[]) 
	{ 
	int n = 5, k = 2; 
	System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k)); 
	} 
} 
/*This code is contributed by Rajat Mishra*/



// JAVA Code for Dynamic Programming | 
// Set 9 (Binomial Coefficient) 
import java.util.*; 

class GFG { 
	
	// Returns value of Binomial 
	// Coefficient C(n, k) 
	static int binomialCoeff(int n, int k) 
	{ 
	
		// Base Cases 
		if (k == 0 || k == n) 
			return 1; 
		
		// Recur 
		return binomialCoeff(n - 1, k - 1) + 
					binomialCoeff(n - 1, k); 
	} 
	
	/* Driver program to test above function */
	public static void main(String[] args) 
{ 
		int n = 5, k = 2; 
		System.out.printf("Value of C(%d, %d) is %d ", 
						n, k, binomialCoeff(n, k)); 
	} 
} 

// This code is contributed by Arnav Kr. Mandal. 
