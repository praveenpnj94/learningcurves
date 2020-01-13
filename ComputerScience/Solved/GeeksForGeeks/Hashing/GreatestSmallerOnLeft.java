//https://practice.geeksforgeeks.org/problems/smaller-on-left2036/0/?track=PC-W3-H&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n,t;
		t=sc.nextInt();
		for(int i=0;i<t;i++){
		n=sc.nextInt();
		int a[]=new int[n];
		for(int j=0;j<n;j++)
		{
		    a[j]=sc.nextInt();
		}
		TreeSet<Integer> ts=new TreeSet<Integer>();
		int res=-1;
		for(int j=0;j<n;j++)
		{res=-1;
		    if(j==0)
        {
           // ts.add(a[0]);
            res=-1;
        }
        else{
            ts.add(a[j-1]);
            if(ts.lower(a[j])==null)
            {
                res=-1;
            }
            else
            {
                res=ts.lower(a[j]);
            }
        }
        System.out.print(res+" ");
		}
		System.out.println(" ");
		}
	}
}