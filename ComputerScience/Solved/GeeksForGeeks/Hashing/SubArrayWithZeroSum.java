//https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/


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
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<arr.length;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    if(subArrayExists(a)){
		        System.out.println("Yes");
		    }
		    else{
		        System.out.println("No");
		    }
		}
	}
	public static boolean subArrayExists(int arr[]) 
    { 
        // Creates an empty hashMap hM 
        HashMap<Integer, Integer> hM =  
                        new HashMap<Integer, Integer>(); 
          
        // Initialize sum of elements 
        int sum = 0;      
          
        // Traverse through the given array 
        for (int i = 0; i < arr.length; i++) 
        {  
            // Add current element to sum 
            sum += arr[i]; 
              
            // Return true in following cases 
            // a) Current element is 0 
            // b) sum of elements from 0 to i is 0 
            // c) sum is already present in hash map 
            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)                          
                return true; 
              
            // Add sum to hash map 
            hM.put(sum, i); 
        }  
          
        // We reach here only when there is 
        // no subarray with 0 sum 
        return false; 
    }
}