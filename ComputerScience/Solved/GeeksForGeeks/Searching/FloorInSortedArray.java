//https://www.geeksforgeeks.org/floor-in-a-sorted-array/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0){
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]);
		    int s = Integer.parseInt(input[1]);
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(getFloor(a,s,n));
		}
	}
	public static int getFloor(int[]a, int s,int n){
	    int res = 0;
	    int i;
	    for(i=0;i<n;i++){
	        if(a[i]>s){
	            res=i-1;
	            break;
	        }
	    }
	    if(i==n){
	        return i-1;
	    }
	    return res;
	}
	public static int floorSearch(int arr[], int low,
                           int high, int x)
    {
        // If low and high cross each other
        if (low > high)
            return -1;

        // If last element is smaller than x
        if (x >= arr[high])
            return high;

        // Find the middle point
        int mid = (low+high)/2;

        // If middle point is floor.
        if (arr[mid] == x)
            return mid;

        // If x lies between mid-1 and mid
        if (mid > 0 && arr[mid-1] <= x && x <
                arr[mid])
            return mid-1;

        // If x is smaller than mid, floor
        // must be in left half.
        if (x < arr[mid])
            return floorSearch(arr, low,
                    mid - 1, x);

        // If mid-1 is not floor and x is
        // greater than arr[mid],
        return floorSearch(arr, mid + 1, high,
                x);
    }

}