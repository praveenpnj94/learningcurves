//https://www.geeksforgeeks.org/array-rotation/
//https://leetcode.com/problems/rotate-array/solution/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] details = br.readLine().split(" ");
		    int n = Integer.parseInt(details[0]);
		    int k = Integer.parseInt(details[1]);
		    String[] arr = br.readLine().split(" ");
		    rotate(arr,k);
		    for(int i=0;i<n;i++){
		        System.out.print(arr[i]+" ");
		    }
		    System.out.println();
		}
	}
    public static void rotate(String[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, n-k - 1);
        reverse(nums, n-k, nums.length - 1);
    }
    public static void reverse(String[] nums, int start, int end) {
        while (start < end) {
            String temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}