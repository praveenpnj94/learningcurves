import java.io.*;
import java.util.*;
 

class Graph
{
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];
 
    Graph(int vertices)
    {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }
 
    void addEdge(int source, int destination)
    {
        adjLists[source].add(destination);
    }
 
    void DFS(int vertex)
    {
        visited[vertex] = true;
        System.out.print(vertex + " ");
 
        Iterator itr = adjLists[vertex].listIterator();
        while (itr.hasNext())
        {
            int adj_node = itr.next();
            if (!visited[adj_node])
                DFS(adj_node);
        }
    }
 
 
    public static void main(String args[])
    {
        Graph g = new Graph(4);
 
         g.addEdge(0, 1);
         g.addEdge(0, 2);
         g.addEdge(1, 2);
         g.addEdge(2, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        g.DFS(2);
    }
}