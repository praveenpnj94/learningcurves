//https://practice.geeksforgeeks.org/problems/3-divisors/0/?track=PC-W1
//https://www.geeksforgeeks.org/numbers-exactly-3-divisors/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws Exception 
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
		   long n = Long.parseLong(br.readLine());
		   int root = (int)Math.sqrt(n);
		   ArrayList<Integer> list = findPrimes(root);
		   
		   System.out.println(list.size());
        }
	}
	
	static ArrayList<Integer> findPrimes(int n)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    boolean[] prime = new boolean[n+1];
	    for(int i=1;i<=n;i++)
	        prime[i] = true;
	    
	    for(int p=2;p*p<=n;p++)
	    {
	        if(prime[p])
	        {
	            for(int i=p*p;i<=n;i+=p)
	                prime[i]=false;
	        }
	    }
	    
	    for(int i=2;i<=n;i++)
	        if(prime[i])
	            list.add(i);
	    
	    return list;
	}
}