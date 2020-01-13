//https://www.geeksforgeeks.org/sort-binary-array-using-one-traversal/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  while(t-->0)
	  {
	      int n=sc.nextInt();
	      int a[]=new int[n];
	      int count=0;
	      for(int i=0;i<n;i++)
	      {
	          a[i]=sc.nextInt();
	          if(a[i]==0)
	          count++;
	      }
	      StringBuffer s=new StringBuffer();
	      int k;
	      for(k=0;k<count;k++)
	      {
	          s.append("0 ");
	      }
	      for(int i=k;i<n;i++)
	      {
	          s.append("1 ");
	      }
	      System.out.println(s);
	  }
	 }
    static void sortBinaryArray(int a[], int n) 
    { 
        int j = -1; 
        for (int i = 0; i < n; i++) { 
  
            // if number is smaller than 1 
            // then swap it with j-th number 
            if (a[i] < 1) { 
                j++; 
                int temp = a[j]; 
                a[j] = a[i]; 
                a[i] = temp; 
            } 
        } 
    }
}

