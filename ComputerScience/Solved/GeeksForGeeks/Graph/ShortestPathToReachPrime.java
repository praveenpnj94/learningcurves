//https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/


import java.util.*;

public class Graph {

	static int V;
	static ArrayList<Integer> adj[];
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		adj = new ArrayList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	int bfs(int a, int b) {
		int vis[] = new int[V+1];
		Arrays.fill(vis, 0);
		Queue<Integer> q = new LinkedList<>();
		vis[a] = 1;
		q.add(a);
		
		while(!q.isEmpty()) {
			int p = q.poll();
			Iterator<Integer> it = adj[p].iterator();
			 while(it.hasNext()) {
				 int next = it.next();
				 if(vis[next]==0) {
					 vis[next] = vis[p]+1;
					 q.add(next);
				 }
				 if(next == b) {
					 return vis[next]-1;
				 }
			 }
			
		}
		return 0;
	}
	
	static boolean compare(int a, int b) 
	{ 
	    // To compare the digits 
		char[] s1 = ("" + a).toCharArray(); 
		char[] s2 = ("" + b).toCharArray(); 
	    int c = 0; 
	    if (s1[0] != s2[0]) 
	        c++; 
	    if (s1[1] != s2[1]) 
	        c++; 
	    if (s1[2] != s2[2]) 
	        c++; 
	    if (s1[3] != s2[3]) 
	        c++; 
	  
	    // If the numbers differ only by a single 
	    // digit return true else false 
	    return (c == 1); 
	} 
	static int shortestPath(int a, int b) {
		ArrayList<Integer> pset = new ArrayList<>();
		SieveOfEratosthenes(pset);
		Graph g = new Graph(pset.size());
	    for (int i = 0; i < pset.size(); i++)  
	        for (int j = i + 1; j < pset.size(); j++)  
	            if (compare(pset.get(i), pset.get(j))) {
	            	g.addEdge(i, j);
	            }
	                
	    int in1 = 0; 
	    int in2 = 0;
	    for (int j = 0; j < pset.size(); j++)  
	        if (pset.get(j) == a) 
	            in1 = j;  
	    for (int j = 0; j < pset.size(); j++)  
	        if (pset.get(j) == b) 
	            in2 = j;  
	  
	    return g.bfs(in1, in2); 
	}
	
	static void SieveOfEratosthenes(ArrayList<Integer> pset) {
		int n = 9999;
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		
		for (int p = 2; p * p <= n; p++) { 
			  
	        // If prime[p] is not changed, then it is a prime 
	        if (prime[p] == true) { 
	  
	            // Update all multiples of p 
	            for (int i = p * p; i <= n; i += p) 
	                prime[i] = false; 
	        } 
	    } 
	  
	    // Forming a vector of prime numbers 
	    for (int p = 1000; p <= n; p++) 
	        if (prime[p]) 
	            pset.add(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(shortestPath(a, b));
	}

}
