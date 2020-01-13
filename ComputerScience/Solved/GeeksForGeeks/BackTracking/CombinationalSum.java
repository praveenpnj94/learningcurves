//https://www.geeksforgeeks.org/combinational-sum/
//https://www.youtube.com/watch?v=vLs6ZMiPtv8

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
		    String[] arr = br.readLine().trim().split(" ");
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    int sum = Integer.parseInt(br.readLine());
		    List<List<Integer>> res = combinationSum(a,n,sum);
		    if(res.size()>0){
		    for(List<Integer> l:res){
		        String r = "(";
		        for(int num:l){
		            r+=num+" ";
		        }
		        r = r.trim() +")";
		        System.out.print(r);
		    }		        
		    }
		    else{
		        System.out.print("Empty");
		    }

		    System.out.println();
		}
	}
	public static List<List<Integer>> combinationSum(int[] a,int n,int sum){
	    List<List<Integer>> res = new ArrayList<>();
	    Arrays.sort(a);
	    n=removeDuplicates(a,n);
	    int[] adash = new int[n];
	    for(int i=0;i<n;i++){
	        adash[i]=a[i];
	    }
	    combinationSumUtil(res,new ArrayList<Integer>(),sum,n,0,adash);
	    return res;
	}
	public static int removeDuplicates(int arr[], int n) 
    { 
        if (n == 0 || n == 1) 
            return n; 
       
        // To store index of next unique element 
        int j = 0; 
       
        // Doing same as done in Method 1 
        // Just maintaining another updated index i.e. j 
        for (int i = 0; i < n-1; i++) 
            if (arr[i] != arr[i+1]) 
                arr[j++] = arr[i]; 
       
        arr[j++] = arr[n-1]; 
       
        return j; 
    }
	public static void combinationSumUtil(List<List<Integer>> res,List<Integer> temp,int sum,int n,int index,int[] a){
	    if(sum<=0){
	        if(sum==0){
	            res.add(new ArrayList<>(temp));
	            return;
	        }
	        return;
	    }
	    for(int i=index;i<n;i++){
	        temp.add(a[i]);
	        combinationSumUtil(res,temp,sum-a[i],n,i,a);
	        temp.remove(temp.size()-1);
	    }
	}
}