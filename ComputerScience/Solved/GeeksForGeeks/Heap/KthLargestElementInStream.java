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
		    int k = Integer.parseInt(dim[0]);
		    int n = Integer.parseInt(dim[1]);
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    int i =0;
		    for(String s:arr){
		        a[i] = Integer.parseInt(arr[i]);
		        i++;
		    }
		    findKthLargestInStream(a,k);
		    System.out.println();
		}
	}
	
	public static void findKthLargestInStream(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int j=0;
        for (int i : nums) {
            q.offer(i);
            j++;
            if(k>j){
                System.out.print("-1 ");
                continue;
            }
            if (q.size() > k) {
                q.poll();
            }
            System.out.print(q.peek()+" ");
        }
    }
}