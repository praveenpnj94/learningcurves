//https://practice.geeksforgeeks.org/problems/prime-factors/0/?track=PC-W1

import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)throws IOException
	 {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	     while(t-->0)
	     {
	       int n=Integer.parseInt(br.readLine()); 
	        while(n%2==0)
	        {    n/=2;
	            if(n%2!=0)
	            System.out.print(2+" ");
	           
	        }
	         for(int i=3;i*i<=n;i+=2)
	         {
	              while(n%i==0)
	              {
	                   n/=i;
	               if(n%i!=0)
	                System.out.print(i+" ");
	                
	              }
	         }
	         if(n>2)
	         System.out.print(n);
	         System.out.println();
	     }
	 }
}