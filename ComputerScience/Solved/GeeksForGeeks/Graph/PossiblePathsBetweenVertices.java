//https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
//https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices/0/?track=PC-W7-GR&batchId=127

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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
		    int s = sc.nextInt();
		    int e = sc.nextInt();
		    boolean[] vis = new boolean[N+1];
		    Arrays.fill(vis,false);
		    int ans = 0;
		    System.out.println(possiblePaths(s,e,ans,N,g.list,vis));
		}
	}
	public static int possiblePaths(int s,int e,int ans,int N,ArrayList<ArrayList<Integer>> list,boolean[] vis){
	    vis[s]=true;
	    if(s==e){
	        ans++;
	    }
	    ArrayList<Integer> al = list.get(s);
	    for(int j=0;j<al.size();j++){
	        int n = al.get(j);
	        if(!vis[n]){
	            ans = possiblePaths(n,e,ans,N,list,vis);
	        }
	    }
	    vis[s]=false;
	    return ans;
	}
}
class Graph{
    int v;
    int e;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Graph(int v,int e){
        this.v=v;
        this.e =e;
        for(int i=0;i<v+1;i++){
            list.add(new ArrayList<Integer>());
        }
    }
    
    void addEdge(int u,int v){
        list.get(u).add(v);
    }
}

// This class represents a directed graph using 
// adjacency list representation 

class Graphs { 

	// No. of vertices 
	private int V; 

	// Array of lists for 
	// Adjacency List 
	// Representation 
	private LinkedList<Integer> adj[]; 

	@SuppressWarnings("unchecked") 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i = 0; i < v; ++i) 
			adj[i] = new LinkedList<>(); 
	} 

	// Method to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 

		// Add w to v's list. 
		adj[v].add(w); 
	} 

	// A recursive method to count 
	// all paths from 'u' to 'd'. 
	int countPathsUtil(int u, int d, 
					int pathCount) 
	{ 

		// If current vertex is same as 
		// destination, then increment count 
		if (u == d) { 
			pathCount++; 
		} 

		// Recur for all the vertices 
		// adjacent to this vertex 
		else { 
			Iterator<Integer> i = adj[u].listIterator(); 
			while (i.hasNext()) { 
				int n = i.next(); 
				pathCount = countPathsUtil(n, d, pathCount); 
			} 
		} 
		return pathCount; 
	} 

	// Returns count of 
	// paths from 's' to 'd' 
	int countPaths(int s, int d) 
	{ 

		// Call the recursive method 
		// to count all paths 
		int pathCount = 0; 
		pathCount = countPathsUtil(s, d, 
								pathCount); 
		return pathCount; 
	} 
} 

// This code is contributed by shubhamjd. 


/*package whatever //do not write package name here */

class GFG {
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
		    int s = sc.nextInt();
		    int e = sc.nextInt();
		    boolean[] vis = new boolean[N+1];
		    Arrays.fill(vis,false);
		    int ans = 0;
		    System.out.println(possiblePaths(s,e,ans,N,g.list,vis));
		}
	}
	public static int possiblePaths(int s,int e,int ans,int N,ArrayList<ArrayList<Integer>> list,boolean[] vis){
	    vis[s]=true;
	    if(s==e){
	        ans++;
	    }
	    ArrayList<Integer> al = list.get(s);
	    for(int j=0;j<al.size();j++){
	        int n = al.get(j);
	        if(!vis[n]){
	            ans = possiblePaths(n,e,ans,N,list,vis);
	        }
	    }
	    vis[s]=false;
	    return ans;
	}
}
class Graph{
    int v;
    int e;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    Graph(int v,int e){
        this.v=v;
        this.e =e;
        for(int i=0;i<v+1;i++){
            list.add(new ArrayList<Integer>());
        }
    }
    
    void addEdge(int u,int v){
        list.get(u).add(v);
    }
}