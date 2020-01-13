//https://practice.geeksforgeeks.org/problems/subarray-range-with-given-sum/0/?track=PC-W3-H&batchId=127


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().split(" ");
		    int x = Integer.parseInt(br.readLine());
		    //System.out.println(givenSumSubArray2(arr,n,x));
		    System.out.println(printallSubarrays(arr,x));
		}
	}
	
	private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
	{
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}

		hashMap.get(key).add(value);
	}
	
	public static int printallSubarrays(String[] A, int sum)
	{
	    int count =0;
		// create a map for storing end index of all subarrays with
		// sum of elements so far
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// To handle the case when the subarray with given sum starts
		// from 0th index
		insert(hashMap, 0, -1);

		int sum_so_far = 0;

		// traverse the given array
		for (int index = 0; index < A.length; index++)
		{
			// sum of elements so far
			sum_so_far += Integer.parseInt(A[index]);

			// check if there exists at-least one sub-array with given sum
			if (hashMap.containsKey(sum_so_far - sum))
			{
				List<Integer> list = hashMap.get(sum_so_far - sum);
				for (Integer value: list) {
					count++;
				}
			}

			// insert (sum so far, current index) pair into the map
			insert(hashMap, sum_so_far, index);
		}
		return count;
	}
}