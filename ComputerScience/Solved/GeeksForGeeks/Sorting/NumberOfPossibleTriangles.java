//https://www.geeksforgeeks.org/find-number-of-triangles-possible/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    long n = Long.parseLong(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[(int)n];
		    for(int i=0;i<arr.length;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(getCountsOfTriangles(a,n));
		}
	}


static void CountTriangles(int[] A) 
{ 
    int n = A.length; 
  
    Arrays.sort(A); 
  
    int count = 0; 
  
    for (int i = n - 1; i >= 1; i--) 
    { 
        int l = 0, r = i - 1; 
        while (l < r) 
        { 
            if (A[l] + A[r] > A[i]) 
            { 
  
                // If it is possible with a[l], a[r] 
                // and a[i] then it is also possible 
                // with a[l+1]..a[r-1],a[r] and a[i] 
                count += r - l; 
  
                //checking for more possible solutions 
                r--; 
            }  
            else // if not possible check for  
                 // higher values of arr[l] 
            { 
                l++; 
            } 
        } 
    } 
    System.out.print("No of possible solutions: " + count); 
} 

	public static long getCountsOfTriangles(int[] nums, long n){
        // Sort the array elements in non-decreasing order
        Arrays.sort(nums);
        
        // Initialize count of triangles
        long ctr = 0L;
 
        for (long i = 0L; i < n-2; ++i)
        {
          long x = i + 2;
 
          for (long j = i+1; j < n; ++j)
            {
               while (x < n && nums[(int)i] + nums[(int)j] > nums[(int)x])
               ++x;
                 ctr += x - j - 1;
            }
        }
        return ctr;
	}
}