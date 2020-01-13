//https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/


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
		    int[] arr = new int[n];
		    String[] a = br.readLine().split(" ");
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(a[i]);
		    }
		    System.out.println(getMaxArea(arr,n));
		}
	}
	public static int maxHistogramArea(int[] a,int n){
	    int maxArea = Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        int localHeight = a[i];
	        int j=i-1;
	        int k=i+1;
	        int area = 0;
	        boolean traversedLeft = false;
	        boolean traversedRight = false;
	        while(j>=0 && a[j]>=localHeight){
	            j--;
	        }
	        while(k<n && a[k]>=localHeight){
	            k++;
	        }
	        if(j<0){
	            area = k*localHeight;
	        }
	        else{
	            area = (k-j-1)*localHeight;
	        }
	        maxArea = Math.max(maxArea,area);
	    }
	    return maxArea;
	}
	
	
	static long getMaxArea(int hist[], int n)  
    { 
        // Create an empty stack. The stack holds indexes of hist[] array 
        // The bars stored in stack are always in increasing order of their 
        // heights. 
        Stack<Integer> s = new Stack<>(); 
          
        long max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        long area_with_top; // To store area with top bar as the smallest bar 
       
        // Run through all bars of given histogram 
        int i = 0; 
        while (i < n) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (s.empty() || hist[s.peek()] <= hist[i]) 
                s.push(i++); 
       
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                tp = s.peek();  // store the top index 
                s.pop();  // pop the top 
       
                // Calculate the area with hist[tp] stack as smallest bar 
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
                // update max area, if needed 
                if (max_area < area_with_top) 
                    max_area = area_with_top; 
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (s.empty() == false) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
  
    }
}