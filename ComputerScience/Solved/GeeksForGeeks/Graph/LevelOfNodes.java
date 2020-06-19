//https://practice.geeksforgeeks.org/problems/level-of-nodes/0/?track=PC-W7-GR&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int finalLevel;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int N = sc.nextInt();
		    int E = sc.nextInt();
		    Graph g = new Graph(N,E);
		    for(int i=0;i<E;i++){
		        int u = sc.nextInt();
		        int v = sc.nextInt();
		        g.addEdge(u,v);
		    }
		    int x = sc.nextInt();
		    int ans =0;
		    finalLevel = -1;
		    boolean[] vis = new boolean[N];
		    Arrays.fill(vis,false);
		    for(int i=0;i<N;i++){
		        if(!vis[i]){
                    levelofNodes(i,ans,x,N,g.list,vis);		            
		        }
		    }
		    System.out.println(finalLevel);
		}
	}
	
	public static void levelofNodes(int i,int ans,int x,int N,ArrayList<ArrayList<Integer>> list,boolean[] vis){
	    vis[i]=true;
	    if(i==x){
	        finalLevel = ans;
	        return;
	    }
	    ArrayList<Integer> al = list.get(i);
	    for(int j=0;j<al.size();j++){
	        int n = al.get(j);
	        if(!vis[n]){
	            levelofNodes(n,ans+1,x,N,list,vis);
	        }
	    }
	}
}
class Graph{
    int v;
    int e;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Graph(int v,int e){
        this.v=v;
        this.e =e;
        for(int i=0;i<v;i++){
            list.add(new ArrayList<Integer>());
        }
    }
    
    void addEdge(int u,int v){
        list.get(u).add(v);
        //list.get(v).add(u);
    }
}


///Another solution using bfs
//https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
class Find_Level
{
	int v;
	LinkedList<Integer> adj[];
	Find_Level(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
           {
           	adj[i]=new LinkedList<>();
           }
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	void findLevel(int x)
	{
           int []level= new int[v];
           boolean []visited=new boolean[v];
           Queue<Integer> q=new LinkedList<>();
           q.add(x);
           visited[x]=true;
           while(!q.isEmpty())
           {
           	x=q.poll();
           	for(Integer i:adj[x])
           	{
                  if(!visited[i])
                  {
                  	q.add(i);
                  	level[i]=level[x]+1;
                  	visited[i]=true;
                  }
           	}
           }
         for(int i=0;i<v;i++)
         {
         	System.out.println("Vertix "+i+" is Level : "+level[i]);
         }  
	}

}