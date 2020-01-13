//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0/?track=PC-W3-H&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
            System.out.println(subArrayZeroSumCount(a));
		}
	}
	public static int subArrayZeroSumCount(int arr[]) 
    { 
        HashMap<Integer, List<Integer>> h =  
                        new HashMap<Integer, List<Integer>>(); 
          
        // Initialize sum of elements 
        int sum = 0;      
        int cnt = 0;
          
        // Traverse through the given array 
        for (int i = 0; i < arr.length; i++) 
        {  
            // Add current element to sum 
            sum += arr[i]; 
            List<Integer> l = new ArrayList<Integer>(); 
            if(sum==0){
                cnt++;
            }
            if(h.containsKey(sum)){
                l = h.get(sum);
                for(Integer t:l){
                    cnt++;
                }
            }
            l.add(i);
            // Add sum to hash map 
            h.put(sum, l); 
        }  
          
        return cnt; 
    }
}