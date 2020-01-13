//https://www.geeksforgeeks.org/find-number-pairs-xy-yx/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int g = 0;g < t;g++)
        {
            String[] str = (br.readLine()).trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            
            int[] x = new int[n];
            str = (br.readLine()).trim().split(" ");
            for(int i = 0;i< n;i++) {
                x[i] = Integer.parseInt(str[i]);
            }
            
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[m];
            for(int i = 0;i< m;i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            
            System.out.println(numPairs(x,y));
        }
	}

	private static long numPairs(int[] A, int[] B) {
	    int n = B.length;
	    Arrays.sort(B);
	    int[] freq = new int[5];
	    for(int i=0;i<n;i++) {
	        if(B[i]<5) {
	            freq[B[i]]++;
	        } else {
	            break;
	        }
	    }
	    
	    long count = 0;
	    for(int i=0;i<A.length;i++) {
	        if(A[i]==0) {
	            continue;
	        }
	        if(A[i]==1) {
	            count = count + (long)freq[0];
	            continue;
	        }
	        count = count + (long)freq[0] + (long)freq[1];
	        int lastIndex = findLastOccurence(B, A[i]);
	        if(lastIndex!=-1) {
	            count = count + (long)(n - lastIndex);
	        }
	        if(A[i]==2) {
	            count = count - (long)freq[3] - (long)freq[4];
	        }
	        if(A[i]==3) {
	            count = count + (long)freq[2];
	        } 
	    }
	    return count;
	}
	
	private static int findLastOccurence(int[] nums, int target) {
	    int n = nums.length;
	    return findLastIndex(nums, target, 0, n-1, n);
	}
	
	private static int findLastIndex(int[] nums, int target, int lo, int hi, int n) {
	    int high = n-1,low = 0;
        int ans = high + 1;
        while(high >= low)
        {
            int mid = (high + low)/2;
            if(nums[mid] > target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
	} 
}