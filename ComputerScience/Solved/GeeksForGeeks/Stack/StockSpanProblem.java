//https://www.geeksforgeeks.org/the-stock-span-problem/

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
		    int[] a = new int[n];
		    String[] arr = br.readLine().split(" ");
		    for(int i=0;i<n;i++){
		        a[i] = Integer.parseInt(arr[i]);
		    }
		    stockspan2(a,n);
		}
	}
	public static void stockspan(int[] a,int n){
	    List<Integer> l = new ArrayList<Integer>();
	    for(int i=0;i<n;i++){
	        if(i==0){
	            l.add(1);
	        }
	        else{
	            int cnt=1;
	            int j = i-1;
	            while(j>=0 && a[j]<=a[i]){
	                cnt++;
	                j--;
	            }
	            l.add(cnt);
	        }
	    }
	    for(int num:l){
	        System.out.print(num+" ");
	    }
	    System.out.println();
	}
    public static void stockspan2(int[] a,int n){
	    List<Integer> l = new ArrayList<Integer>();
	    Stack<Integer> s = new Stack<>();
	    l.add(1);
	    s.push(0);
	    for(int i=1;i<n;i++){
	        while(!s.isEmpty() && a[s.peek()]<=a[i]){
	            s.pop();
	        }
	        l.add(s.isEmpty()?i+1:i-s.peek());
	        s.push(i);
	    }
	    for(int num:l){
	        System.out.print(num+" ");
	    }
	    System.out.println();
	}
}