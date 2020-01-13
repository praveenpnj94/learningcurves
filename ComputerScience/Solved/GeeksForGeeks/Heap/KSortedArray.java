//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
//https://www.youtube.com/watch?v=yQ84lk-EXTQ

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
		    kSort(a,n,k);
		    System.out.println();
		}
	}
	
	 public static void kSort(int[] arr, int n, int k)  
    { 
  
        // min heap 
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 
  
        // add first k + 1 items to the min heap 
        for(int i = 0; i < k + 1; i++) 
        { 
            priorityQueue.add(arr[i]); 
        } 
  
        int index = 0; 
        for(int i = k + 1; i < n; i++)  
        { 
            arr[index++] = priorityQueue.peek(); 
            System.out.print(arr[index-1]+" ");
            priorityQueue.poll(); 
            priorityQueue.add(arr[i]); 
        } 
  
        Iterator<Integer> itr = priorityQueue.iterator(); 
  
        while(itr.hasNext())  
        { 
            arr[index++] = priorityQueue.peek(); 
            System.out.print(arr[index-1]+" ");
            priorityQueue.poll(); 
        } 
  
    }
}