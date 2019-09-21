//https://www.geeksforgeeks.org/maximum-product-increasing-subsequence-size-3/
//https://www.ideserve.co.in/learn/increasing-subsequence-of-length-three-for-maximum-product

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    static void maxProductSubsequence(int arr[], int n, long res[]) { 
        long smaller[] = new long[(int)n];
        TreeSet<Integer> S = new TreeSet<Integer>();
        for (int i = 0; i < n ; i++) {
            S.add(arr[i]);
            int lowerElement = 0;
            if(S.lower(arr[i])==null){
                lowerElement = -1;
            } else {
                lowerElement = S.lower(arr[i]);
            }
                smaller[i] = lowerElement;
        } 
        long result = Integer.MIN_VALUE; 
        int max_right = arr[n-1];
        for(int i=n-2 ; i >= 1; i--) {
            if(arr[i] >= max_right){
                max_right = arr[i];
            } else if (smaller[i] != -1) {
                long tmpRes = smaller[i] * arr[i] * max_right; 
                if(result < tmpRes){
                    result = tmpRes;
                    res[0] = smaller[(int)i];
                    res[1] = arr[i];
                    res[2] = max_right;
                }
            }
        }
    } 
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
            
		    long res[] = new long[(int)3];
		    maxProductSubsequence(arr, n, res);
		    StringBuffer str = new StringBuffer();
		    if(res[0]==0){
		        str.append("Not Present");
		    } else {
		        for(int i=0; i<3; i++){
		            str.append(res[i]+" ");
		        }
		    }
		    System.out.println(str);
            
		}
	}
}