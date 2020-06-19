//https://www.youtube.com/watch?v=XB4MIexjvY0
//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/
//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
//

// Java implementation of Dijkstra's Algorithm 
// using Priority Queue 
import java.util.*; 
public class DPQ { 
	private int dist[]; 
	private Set<Integer> settled; 
	private PriorityQueue<Node> pq; 
	private int V; // Number of vertices 
	List<List<Node> > adj; 

	public DPQ(int V) 
	{ 
		this.V = V; 
		dist = new int[V]; 
		settled = new HashSet<Integer>(); 
		pq = new PriorityQueue<Node>(V, new Node()); 
	} 

	// Function for Dijkstra's Algorithm 
	public void dijkstra(List<List<Node> > adj, int src) 
	{ 
		this.adj = adj; 

		for (int i = 0; i < V; i++) 
			dist[i] = Integer.MAX_VALUE; 

		// Add source node to the priority queue 
		pq.add(new Node(src, 0)); 

		// Distance to the source is 0 
		dist[src] = 0; 
		while (settled.size() != V) { 

			// remove the minimum distance node 
			// from the priority queue 
			int u = pq.remove().node; 

			// adding the node whose distance is 
			// finalized 
			settled.add(u); 

			e_Neighbours(u); 
		} 
	} 

	// Function to process all the neighbours 
	// of the passed node 
	private void e_Neighbours(int u) 
	{ 
		int edgeDistance = -1; 
		int newDistance = -1; 

		// All the neighbors of v 
		for (int i = 0; i < adj.get(u).size(); i++) { 
			Node v = adj.get(u).get(i); 

			// If current node hasn't already been processed 
			if (!settled.contains(v.node)) { 
				edgeDistance = v.cost; 
				newDistance = dist[u] + edgeDistance; 

				// If new distance is cheaper in cost 
				if (newDistance < dist[v.node]) 
					dist[v.node] = newDistance; 

				// Add the current node to the queue 
				pq.add(new Node(v.node, dist[v.node])); 
			} 
		} 
	} 

	// Driver code 
	public static void main(String arg[]) 
	{ 
		int V = 5; 
		int source = 0; 

		// Adjacency list representation of the 
		// connected edges 
		List<List<Node> > adj = new ArrayList<List<Node> >(); 

		// Initialize list for every node 
		for (int i = 0; i < V; i++) { 
			List<Node> item = new ArrayList<Node>(); 
			adj.add(item); 
		} 

		// Inputs for the DPQ graph 
		adj.get(0).add(new Node(1, 9)); 
		adj.get(0).add(new Node(2, 6)); 
		adj.get(0).add(new Node(3, 5)); 
		adj.get(0).add(new Node(4, 3)); 

		adj.get(2).add(new Node(1, 2)); 
		adj.get(2).add(new Node(3, 4)); 

		// Calculate the single source shortest path 
		DPQ dpq = new DPQ(V); 
		dpq.dijkstra(adj, source); 

		// Print the shortest path to all the nodes 
		// from the source node 
		System.out.println("The shorted path from node :"); 
		for (int i = 0; i < dpq.dist.length; i++) 
			System.out.println(source + " to " + i + " is "
							+ dpq.dist[i]); 
	} 
} 

// Class to represent a node in the graph 
class Node implements Comparator<Node> { 
	public int node; 
	public int cost; 

	public Node() 
	{ 
	} 

	public Node(int node, int cost) 
	{ 
		this.node = node; 
		this.cost = cost; 
	} 

	@Override
	public int compare(Node node1, Node node2) 
	{ 
		if (node1.cost < node2.cost) 
			return -1; 
		if (node1.cost > node2.cost) 
			return 1; 
		return 0; 
	} 
} 




class ShortestPath { 
	// A utility function to find the vertex with minimum distance value, 
	// from the set of vertices not yet included in shortest path tree 
	static final int V = 9; 
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) { 
				min = dist[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 

	// A utility function to print the constructed distance array 
	void printSolution(int dist[]) 
	{ 
		System.out.println("Vertex \t\t Distance from Source"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t\t " + dist[i]); 
	} 

	// Function that implements Dijkstra's single source shortest path 
	// algorithm for a graph represented using adjacency matrix 
	// representation 
	void dijkstra(int graph[][], int src) 
	{ 
		int dist[] = new int[V]; // The output array. dist[i] will hold 
		// the shortest distance from src to i 

		// sptSet[i] will true if vertex i is included in shortest 
		// path tree or shortest distance from src to i is finalized 
		Boolean sptSet[] = new Boolean[V]; 

		// Initialize all distances as INFINITE and stpSet[] as false 
		for (int i = 0; i < V; i++) { 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		// Distance of source vertex from itself is always 0 
		dist[src] = 0; 

		// Find shortest path for all vertices 
		for (int count = 0; count < V - 1; count++) { 
			// Pick the minimum distance vertex from the set of vertices 
			// not yet processed. u is always equal to src in first 
			// iteration. 
			int u = minDistance(dist, sptSet); 

			// Mark the picked vertex as processed 
			sptSet[u] = true; 

			// Update dist value of the adjacent vertices of the 
			// picked vertex. 
			for (int v = 0; v < V; v++) 

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
					dist[v] = dist[u] + graph[u][v]; 
		} 

		// print the constructed distance array 
		printSolution(dist); 
	} 

	// Driver method 
	// public static void main(String[] args) 
	// { 
	// 	/* Let us create the example graph discussed above */
	// 	int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
	// 								{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
	// 								{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
	// 								{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
	// 								{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
	// 								{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
	// 								{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
	// 								{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
	// 								{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
	// 	ShortestPath t = new ShortestPath(); 
	// 	t.dijkstra(graph, 0); 
	// } 
} 
// This code is contributed by Aakash Hasija 

