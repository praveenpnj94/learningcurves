//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/?track=PC-W7-GR&batchId=127

// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            boolean vis[] = new boolean[nov];
            for(int i = 0; i < nov; i++)
                vis[i] = false;
            new Traversal().dfs(0, list, vis);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
*ArrayList<ArrayList<Integer>> list: which represents graph
* src: represents source vertex
*vis[]: boolean array 
*/

class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
       vis[src]=true;
       System.out.print(src+" ");
       ArrayList<Integer> al = list.get(src);
       for(int i=0;i<al.size();i++){
           int n = al.get(i);
           if(!vis[n]){
               dfs(n,list,vis);
           }
       }
    }
}