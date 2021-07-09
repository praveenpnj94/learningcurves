//https://www.geeksforgeeks.org/find-significant-set-bit-number/

import java.io.*; 

class GFG 
{ 
static int setBitNumber(int n) 
{ 
	if (n == 0) 
		return 0; 

	int msb = 0; 
	while (n != 0) 
	{ 
		n = n / 2; 
		msb++; 
	} 

	return msb; 
} 

static int setBitNumber2(int n) 
{ 
    int k = (int)(Math.log(n) / Math.log(2)); 
  
    // To return the the value of the number 
    // with set bit at k-th position 
    return k;
}

// Driver code 
public static void main (String[] args) 
{ 
	int n = 2; 
	System.out.println(setBitNumber(n)); 
} 
} 


