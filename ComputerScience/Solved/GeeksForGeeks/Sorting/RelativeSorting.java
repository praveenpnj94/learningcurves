//https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] dim = br.readLine().split(" ");;
		    int m = Integer.parseInt(dim[0]);
		    int n = Integer.parseInt(dim[1]);
		    String[] arr = br.readLine().split(" ");
		    String[] brr = br.readLine().split(" ");
		    relativeSorting(arr,brr,m,n);
		    System.out.println();
		}
	}
	public static void relativeSorting(String[] a, String[] b, int m, int n){
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    for(int i=0;i<m;i++){
	        if(map.containsKey(a[i])){
	            int cnt = map.get(a[i]);
	            map.put(a[i],cnt+1);
	        }
	        else{
	            map.put(a[i],1);
	        }
	    }
	    for(int j=0;j<n;j++){
	        if(map.containsKey(b[j])){
	            int cn = map.get(b[j]);
	            for(int k=0;k<cn;k++){
	                System.out.print(b[j]+" ");
	            }
	            map.remove(b[j]);
	        }
	    }
	    TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
	    for(Map.Entry<String, Integer> entry: map.entrySet()){
	        String key = entry.getKey();
	        int value = entry.getValue();
	        sortedMap.put(Integer.parseInt(key),value);
	    }
	    for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()){
	        int key = entry.getKey();
	        int value = entry.getValue();
	        for(int idx=0;idx<value;idx++){
	            System.out.print(key+" ");
	        }
	    }
	}

    /* A Binary Search based function to find 
    index of FIRST occurrence of x in arr[]. 
    If x is not present, then it returns -1 */
    static int first(int arr[], int low, int high, 
                     int x, int n) 
    { 
        if (high >= low) { 
            /* (low + high)/2; */
            int mid = low + (high - low) / 2; 
  
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) 
                return mid; 
            if (x > arr[mid]) 
                return first(arr, (mid + 1), high, 
                             x, n); 
            return first(arr, low, (mid - 1), x, n); 
        } 
        return -1; 
    } 
  
    // Sort A1[0..m-1] according to the order 
    // defined by A2[0..n-1]. 
    static void sortAccording(int A1[], int A2[], int m, 
                              int n) 
    { 
        // The temp array is used to store a copy 
        // of A1[] and visited[] is used to mark the 
        // visited elements in temp[]. 
        int temp[] = new int[m], visited[] = new int[m]; 
        for (int i = 0; i < m; i++) { 
            temp[i] = A1[i]; 
            visited[i] = 0; 
        } 
  
        // Sort elements in temp 
        Arrays.sort(temp); 
  
        // for index of output which is sorted A1[] 
        int ind = 0; 
  
        // Consider all elements of A2[], find them 
        // in temp[] and copy to A1[] in order. 
        for (int i = 0; i < n; i++) { 
            // Find index of the first occurrence 
            // of A2[i] in temp 
            int f = first(temp, 0, m - 1, A2[i], m); 
  
            // If not present, no need to proceed 
            if (f == -1) 
                continue; 
  
            // Copy all occurrences of A2[i] to A1[] 
            for (int j = f; (j < m && temp[j] == A2[i]); 
                 j++) { 
                A1[ind++] = temp[j]; 
                visited[j] = 1; 
            } 
        } 
  
        // Now copy all items of temp[] which are 
        // not present in A2[] 
        for (int i = 0; i < m; i++) 
            if (visited[i] == 0) 
                A1[ind++] = temp[i]; 
    }
}