//https://www.interviewbit.com/problems/divide-integers/
//https://www.geeksforgeeks.org/divide-two-integers-without-using-multiplication-division-mod-operator/

/*Java implementation to Divide two 
integers without using multiplication, 
division and mod operator*/

import java.io.*; 

class GFG 
{ 
	
	// Function to divide a by b and 
	// return floor value it 
	static int divide(int dividend, int divisor) 
	{ 
		
		// Calculate sign of divisor i.e., 
		// sign will be negative only iff 
		// either one of them is negative 
		// otherwise it will be positive 
		int sign = ((dividend < 0) ^ 
				(divisor < 0)) ? -1 : 1; 
	
		// Update both divisor and 
		// dividend positive 
		dividend = Math.abs(dividend); 
		divisor = Math.abs(divisor); 
	
		// Initialize the quotient 
		int quotient = 0; 
		
		while (dividend >= divisor) 
		{ 
			dividend -= divisor; 
			++quotient; 
		} 
	
		return sign * quotient; 
	}	 
	
	public static void main (String[] args) 
	{ 
		int a = 10; 
		int b = 3; 
		
		System.out.println(divide(a, b)); 
		
		a = 43; 
		b = -8; 
		
		System.out.println(divide(a, b)); 
	} 
} 

// This code is contributed by upendra singh bartwal. 

