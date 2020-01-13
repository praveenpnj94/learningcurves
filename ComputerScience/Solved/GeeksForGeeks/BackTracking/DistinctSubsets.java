//https://www.techiedelight.com/print-distinct-subsets-given-set/


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
		    findPowerSet(a);
		    System.out.println();
		}
	}
	
	
    public static void findPowerSet(int[] S)
	{
	    Arrays.sort(S);
		// N stores total number of subsets
		int N = (int)Math.pow(2, S.length);
		TreeSet<String> set = new TreeSet<>();

		// generate each subset one by one
		for (int i = 0; i < N; i++)
		{
			String subset = "";

			// check every bit of i
			for (int j = 0; j < S.length; j++) {
				// if j'th bit of i is set, append S[j] to subset
				if ((i & (1 << j)) != 0) {
					subset += (S[j]) + " ";
				}
			}

			// insert the subset into the set
			set.add(subset);
		}

        
		// print all subsets present in the set
		for (String subset: set) {
            System.out.print("("+subset.trim()+")");
		}
		
	}

}