//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
//https://www.youtube.com/watch?v=yQ84lk-EXTQ


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
 
class Main
{
    // Function to sort a k–sorted array
    public static void sortKSortedArray(List<Integer> list, int k)
    {
        // create an empty min-heap and insert the first `k+1` elements into it
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k+1));
 
        int index = 0;
 
        // do for remaining elements in the array
        for (int i = k + 1; i < list.size(); i++)
        {
            // pop the top element from the min-heap and assign them to the
            // next available array index
            list.set(index++, pq.poll());
 
            // push the next array element into min-heap
            pq.add(list.get(i));
        }
 
        // pop all remaining elements from the min-heap and assign them to the
        // next available array index
        while (!pq.isEmpty()) {
            list.set(index++, pq.poll());
        }
    }
 
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;
 
        sortKSortedArray(list, k);
        System.out.println(list);
    }
}

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