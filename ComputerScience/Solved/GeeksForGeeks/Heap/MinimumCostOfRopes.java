//https://leetcode.com/discuss/interview-question/344677/Amazon-or-Online-Assessment-2019-or-Min-Cost-to-Connect-Ropes
//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t --> 0){
		    int n = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    long[] a = new long[n];
		    for(int i=0;i<n;i++){
		        a[i]=Long.parseLong(arr[i]);
		    }
		    System.out.println(minCostOfRopes(a,n));
		}
	}
	public static long minCostOfRopes(long[] ropes, int n){
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        for(long rope: ropes) pQueue.add(rope);
        long cost = 0L;
        while(pQueue.size() !=1) {
            //System.out.println(Arrays.toString(pQueue.toArray()));
            long temp = pQueue.poll() + pQueue.poll();
            cost += temp;
            pQueue.add(temp);
        }
        return cost;
	}
}