
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            int x = Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(line[i]);
            }
            System.out.println(search(arr,n,x));
        }
	 }
	 public static int search(int[] arr,int n,int x){
	    int l=0;
        int r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]==x){
                return mid;
            }else if((mid-1)>=0 &&arr[mid-1]==x){
                return mid-1;
            }else if ((mid+1)<n &&arr[mid+1]==x){
                return mid+1;
            }else if(arr[mid]<x){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
	 }
}