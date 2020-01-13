//https://www.geeksforgeeks.org/count-subarrays-equal-number-1s-0s/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    System.out.println(countSubarrWithEqualZeroAndOne(a,n));
		}
	}
	public static int countSubarrWithEqualZeroAndOne(int[] arr, int n) { 
        Map<Integer, Integer> myMap = new HashMap<>(); 
        int sum = 0; 
        int count = 0; 
        for (int i = 0; i < n; i++) { 
            //Replacing 0's in array with -1 
            if (arr[i] == 0) 
                arr[i] = -1; 
          
            sum += arr[i]; 
              
            //If sum = 0, it implies number of 0's and 1's are  
            //equal from arr[0]..arr[i] 
            if (sum == 0) 
                count++; 
              
            if (myMap.containsKey(sum)) 
                count += myMap.get(sum); 
  
            if (!myMap.containsKey(sum)) 
                myMap.put(sum, 1); 
            else
                myMap.put(sum, myMap.get(sum) + 1); 
        } 
        return count; 
    }
}