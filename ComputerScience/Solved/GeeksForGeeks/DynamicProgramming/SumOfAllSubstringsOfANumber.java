//https://www.geeksforgeeks.org/sum-substrings-string-representing-number-set-2-constant-extra-space/
//https://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    Long l = sc.nextLong();
		    System.out.println(sumOfSubstrings(l.toString()));
		}
	}
	public static long sumOfSubstrings(String num){
        long sum = 0; // Initialize result 
       
        // Here traversing the array in reverse 
        // order.Initializing loop from last 
        // element. 
        // mf is multiplying factor. 
        long mf = 1; 
        for (int i = num.length() - 1; i >= 0; i --) 
        { 
            // Each time sum is added to its previous 
            // sum. Multiplying the three factors as 
            // explained above. 
            // s[i]-'0' is done to convert char to int. 
            sum += (num.charAt(i) - '0') * (i + 1) * mf; 
       
            // Making new multiplying factor as 
            // explained above. 
            mf = mf * 10 + 1; 
        } 
       
        return sum; 	    
	}
	    public static int sumOfSubstrings(String num) 
    { 
        int n = num.length(); 
          
        //  allocate memory equal to length of string 
        int sumofdigit[] = new int[n]; 
       
        //  initialize first value with first digit 
        sumofdigit[0] = num.charAt(0)-'0'; 
        int res = sumofdigit[0]; 
       
        //  loop over all digits of string 
        for (int i = 1; i < n; i++) 
        { 
            int numi = num.charAt(i)-'0'; 
       
            // update each sumofdigit from previous value 
            sumofdigit[i] = (i+1) * numi + 
                            10 * sumofdigit[i-1]; 
       
            // add current value to the result 
            res += sumofdigit[i]; 
        } 
       
        return res; 
    }
}