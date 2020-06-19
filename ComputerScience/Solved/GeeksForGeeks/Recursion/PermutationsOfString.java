//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
//https://www.youtube.com/watch?v=GuTPwotSdYw

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String s = br.readLine();
		    List<String> arr = new ArrayList<String>();
		    permute(s,0,s.length()-1,arr);
		    Collections.sort(arr);
		    for(int i=0;i<arr.size();i++){
		        System.out.print(arr.get(i)+" ");
		    }
		    System.out.println();
		}
	}
	public static void permute(String s,int l,int r, List<String> arr){
	    if(l==r){
	        arr.add(s);
	        return;
	    }
	    for(int i=l;i<=r;i++){
	        s=swap(s,l,i);
	        permute(s,l+1,r,arr);
	        s=swap(s,l,i);
	    }
	}
	public static String swap(String s,int i, int j){
	    char[] charArray = s.toCharArray();
	    char temp = charArray[i];
	    charArray[i]=charArray[j];
	    charArray[j] = temp;
	    return String.valueOf(charArray);
	}
	
}