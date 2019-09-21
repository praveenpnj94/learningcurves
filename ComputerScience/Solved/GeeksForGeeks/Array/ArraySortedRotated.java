//https://www.geeksforgeeks.org/check-if-an-array-is-sorted-and-rotated/

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
            String split[] = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(split[i]);
            }
            boolean flag1 = IncSorted(arr,n);
            boolean flag2 = DecSorted(arr,n);
            if(flag1 || flag2){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
	 }
	 public static boolean IncSorted(int arr[],int n){
	     int min=Integer.MAX_VALUE;
	     int min_idx=-1;
	     for(int i=0;i<n;i++){
	         if(arr[i]<min){
	             min=arr[i];
	             min_idx=i;
	         }
	     }
	     boolean flag1=true;
	     for(int i=1;i<min_idx;i++){
	         if(arr[i]<arr[i-1]){
	             flag1=false;
	             break;
	         }
	     }
	     boolean flag2=true;
	     for(int i=min_idx;i<n-1;i++){
	         if(arr[i+1]<arr[i]){
	             flag2=false;
	             break;
	         }
	     }
	     if(flag1 && flag2 && (arr[n-1]<arr[0]) ){
	         return true;
	     }
	     return false;
	 }
	 public static boolean DecSorted(int arr[],int n){
	     int max=Integer.MIN_VALUE;
	     int max_idx=-1;
	     for(int i=0;i<n;i++){
	         if(max<arr[i]){
	             max=arr[i];
	             max_idx=i;
	         }
	     }
	     boolean flag1=true;
	     for(int i=1;i<max_idx;i++){
	         if(arr[i-1]<arr[i]){
	             flag1=false;
	             break;
	         }
	     }
	     boolean flag2=true;
	     for(int i=max_idx;i<n-1;i++){
	         if(arr[i+1]>arr[i]){
	             flag2=false;
	             break;
	         }
	     }
	     if(flag1 && flag2 && (arr[n-1]>arr[0])){
	         return true;
	     }
	     return false;
	 }
}