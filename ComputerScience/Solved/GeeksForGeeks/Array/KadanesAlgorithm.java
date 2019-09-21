//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            int n = Integer.parseInt(br.readLine());
            String split[] = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(split[i]);
            }
            System.out.println(maxSubArraySum(arr,n));
        }
	 }
public static int maxSubArraySum(int a[],int size)  
{  
      
    int max_so_far = a[0],curr_max = a[0];  
  
    for (int i = 1; i < size; i++)  
    {  
        curr_max = Math.max(a[i],curr_max+a[i]);
        max_so_far = Math.max(max_so_far,curr_max);
          
    }  
    return max_so_far;  
}  
  
}