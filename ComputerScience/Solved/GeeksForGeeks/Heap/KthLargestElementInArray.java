/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] dim = br.readLine().split(" ");
		    int n = Integer.parseInt(dim[0]);
		    int k = Integer.parseInt(dim[1]);
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    int i =0;
		    for(String s:arr){
		        a[i] = Integer.parseInt(arr[i]);
		        i++;
		    }
		    System.out.println(findKthLargest(a,k));
		}
	}
	
	public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : nums) {
            q.offer(i);
 
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek(); //To print kth Largest element
    }
}