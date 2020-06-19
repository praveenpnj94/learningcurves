//https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/

// /*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
//     public static void main (String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         while(t-->0){
//             int n = Integer.parseInt(br.readLine());
//             String s = br.readLine();
//             String[] sa = s.trim().split(" ");
//             System.out.println(circleOfStrings(sa));
//         }
//     }
//     public static int circleOfStrings(String[] sa){
//         if(sa.length==1 && sa[0].length()==1){
//             return 1;
//         }
//         Graph g = new Graph(26);
//         for(String s:sa){
//             int l = s.length();
//             addEdge(s.charAt(0)-'a', s.charAt(l-1)-'a',g);
//         }
//         if(isEuler(g)){
//             return 1;
//         }
//         else{
//             return 0;
//         }
//     }
//     public static boolean isEuler(Graph g){
//         // Check if all non-zero degree vertices are connected
//         if (isSC(g) == false)
//             return false;

//         // Check if in degree and out degree of every vertex is same
//         for (int i = 0; i < g.v; i++)
//             if (g.adj.get(i).size() != g.in[i])
//                 return false;

//         return true;
//     }
//     public static boolean isSC(Graph g){
//         int v = g.v;
//         boolean[] vis = new boolean[v];
//         dfs(0,vis,g);
//         for(int i=0;i<v;i++){
//             if(!vis[i] && g.adj.get(i).size()>0){
//                 return false;
//             }
//         }
//         Graph gt = getTranspose(g);
//         Arrays.fill(vis,false);
//         dfs(0,vis,gt);
//         for(int i=0;i<v;i++){
//             if(!vis[i] && gt.adj.get(i).size()>0){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public static Graph getTranspose(Graph g){
//         int v = g.v;
//         Graph gr = new Graph(v);
//         for(int i=0;i<v;i++){
//             for(int m=0;m<g.adj.get(i).size();m++){
//                 gr.adj.get(g.adj.get(i).get(m)).add(i);
//             }
//         }
//         return gr;
//     }
//     public static void dfs(int v, boolean[] vis, Graph g){
//         vis[v] = true;
//         ArrayList<ArrayList<Integer>> adj = g.adj;
//         ArrayList<Integer> al = adj.get(v);
//         if(al!=null && !al.isEmpty()){
//             for(int i=0;i<al.size();i++){
//                 int n = al.get(i);
//                 if(!vis[n]){
//                     dfs(n,vis,g);
//                 }
//             }
//         }
//     }
//     public static void addEdge(int u,int v,Graph g){
//         g.adj.get(u).add(v);
//         g.in[v]=g.in[v]+1;
//     }
// }
// class Graph{
//     int v;
//     int[] in;
//     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//     Graph(int v){
//         this.v = v;
//         in = new int[v];
//         for(int i=0;i<v;i++){
//             adj.add(new ArrayList<>());
//         }
//     }
// }
import java.util.*; 
import java.lang.*;
import java.io.*;

class Graph { 
	int V; 
	LinkedList<Integer> adj[]; 
	int in[];
	Graph(int v) { 
		V = v; 
		adj = new LinkedList[v]; 
		in = new int[V]; 
		for (int i=0; i<v; ++i) { 
			adj[i] = new LinkedList(); 
			in[i] = 0; 
		} 
	} 
 
	void addEdge(int v,int w) { 
		adj[v].add(w); 
		in[w]++; 
	} 
	
	void DFSUtil(int v, Boolean visited[]) { 
	    visited[v] = true; 
		int n;  
		Iterator<Integer> i = adj[v].iterator(); 
		while(i.hasNext()) { 
			n = i.next(); 
			if(!visited[n]) 
				DFSUtil(n, visited); 
		} 
	} 
	
	Graph getTranspose() { 
		Graph g = new Graph(V); 
		for (int v = 0; v < V; v++) { 
			Iterator<Integer> i = adj[v].listIterator(); 
			while(i.hasNext()) { 
				g.adj[i.next()].add(v); 
				(g.in[v])++; 
			} 
		} 
		return g; 
	} 

	Boolean isSC() { 
		// Step 1: Mark all the vertices as not visited (For 
		// first DFS) 
		Boolean visited[] = new Boolean[V]; 
		Arrays.fill(visited, false);

		// Step 2: DFS starting from 1st non-zero degree vertex
		int n;
		for(n=0; n<V; n++){
		    if(adj[n].size()>0)break;
		}
		DFSUtil(n, visited); 
		/*for(int j=0; j<V; j++)System.out.print(visited[j] + " ");
		System.out.println();*/
		// If DFS traversal doesn't visit all vertices, then return false. 
		for (int i = 0; i < V; i++) 
			if (!visited[i] && adj[i].size() >0) 
				return false; 

		// Step 3: Create a reversed graph 
		Graph gr = getTranspose(); 

		// Step 4: Mark all the vertices as not visited (For second DFS) 
		Arrays.fill(visited, false);

		// Step 5: Do DFS for reversed graph starting from first vertex. 
		// Staring Vertex must be same starting point of first DFS 
		gr.DFSUtil(n, visited); 
		/*for(int j=0; j<V; j++)System.out.print(visited[j] + " ");
		System.out.println();*/
		// If all vertices are not visited in second DFS, then 
		// return false 
		for(int i = 0; i < V; i++) 
			if(!visited[i] && adj[i].size() > 0) 
				return false; 
		return true; 
	} 

	/* This function returns true if the directed graph has an eulerian 
	cycle, otherwise returns false */
	Boolean isEulerianCycle() { 
		// Check if all non-zero degree vertices are connected 
		if (isSC() == false) 
			return false; 
		// Check if in degree and out degree of every vertex is same 
		for (int i = 0; i < V; i++) 
			if (adj[i].size() != in[i]) 
				return false; 
		return true; 
	} 
	
	 static void canBeChained(String[] arr, int n){
	    Graph g = new Graph(26);
	    for(int i=0; i<n; i++){
	        String s = arr[i];
	        g.addEdge(s.charAt(0)-'a', s.charAt(s.length()-1)-'a');
	    }
	    /*for(int i=0; i<g.V; i++){
	        System.out.print(i+" -> ");
	        Iterator<Integer> it = g.adj[i].listIterator();
	        while(it.hasNext()){
	            System.out.print(it.next()+" ");
	        }
	        System.out.println();
	    }*/
	    if(g.isEulerianCycle()){
	        System.out.println("1");
	    } else {
	        System.out.println("0");
	    }
	}
	
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    inputLine = br.readLine().trim().split(" ");
		    canBeChained(inputLine, n);
		}
	}
}