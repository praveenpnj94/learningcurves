//https://practice.geeksforgeeks.org/problems/coins-and-game/0/?track=PC-W8-BK&batchId=127

import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	Scanner s=new Scanner(System.in);
	int t=s.nextInt();
	for(int p=0;p<t;p++)
	{
		int n=s.nextInt();
		int m=s.nextInt();
		int[] arr=new int[m];
		arr=getcoins(n,m,arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
}

private static int[] getcoins(int n, int m, int[] arr) {
	// TODO Auto-generated method stub
	if(m%2==0)
	{
		arr[0]=n-((m-2)/2);
		for(int i=2;i<arr.length;i+=2)
		{
			arr[i]=1;
		}
		return arr;
	}
	else
	{
		arr[0]=n-m/2;
		for(int i=2;i<arr.length;i+=2)
		{
			arr[i]=1;
		}
		return arr;
	}
	
	
}
}
