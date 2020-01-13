//https://www.youtube.com/watch?v=VmogG01IjYc
//https://leetcode.com/problems/find-median-from-data-stream/solution/
//https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int n = t;
		int[] a = new int[t];
		int idx = 0;
		while(t-->0){
		    a[idx]=Integer.parseInt(br.readLine().trim());
		    idx++;
		}
		findMedianInStream(a,n);
	}
	public static void findMedianInStream(int[]a, int n){
	    PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder());
	    PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
	    double[] medians = new double[n];
	    for(int i=0;i<n;i++){
	        int num = a[i];
	        addNumbersInBucketHeap(num,lowers,highers);
	        rebalance(lowers,highers);
	        medians[i] = getMedian(lowers,highers);
	        System.out.println((int)Math.floor(medians[i]));
	    }
	}
	public static void addNumbersInBucketHeap(int num , PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
	    if(lowers.size()==0 || num < lowers.peek()){
	        lowers.add(num);
	    }
	    else{
	        highers.add(num);
	    }
	}
    public static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
	    PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
	    if((biggerHeap.size()-smallerHeap.size())>=2){
	        smallerHeap.add(biggerHeap.poll());
	    }
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
	    PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
	    if((biggerHeap.size()==smallerHeap.size())){
	        return ((double)biggerHeap.peek()+smallerHeap.peek())/2;
	    }
	    else{
	        return biggerHeap.peek();
	    }
	}
}