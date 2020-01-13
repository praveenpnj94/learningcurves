//https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int k = Integer.parseInt(br.readLine().trim());
		    int n = Integer.parseInt(br.readLine().trim());
		    String[] arr = br.readLine().trim().split(" ");
		    int[] a = new int [n];
		    for(int i =0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    System.out.println(getMinDiff(a,n,k));
		}
	}
	
	public static int getMinDiff(int arr[], int n, int k)
    {
        if (n == 1)
            return 0;

        // Sort all elements
        Arrays.sort(arr);

        // Initialize result
        int ans = arr[n-1] - arr[0];

        // Handle corner elements
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        int temp = 0;

        if (small > big)
        {
            temp = small;
            small = big;
            big = temp;
        }

        // Traverse middle elements
        for (int i = 1; i < n-1; i ++)
        {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            // If both subtraction and addition
            // do not change diff
            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller
            // number or addition causes a greater
            // number. Update small or big using
            // greedy approach (If big - subtract
            // causes smaller diff, update small
            // Else update big)
            if (big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }

        return Math.min(ans, big - small);
    }
}