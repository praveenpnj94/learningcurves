//https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1/?track=sp-graph&batchId=122
//https://www.geeksforgeeks.org/check-removing-given-edge-disconnects-given-graph/
// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Graph {
    int v;
    int e;

    ArrayList<Integer>[] edges;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;

        edges = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

}

class Gfg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            Graph g = new Graph(v, e);

            for (int i = 0; i < e; i++) {
                g.addEdge(sc.nextInt(), sc.nextInt());
            }

            Solution obj = new Solution();
            obj.isBridge(g, sc.nextInt(), sc.nextInt());
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Graph {
//     int v;   --> no of vertices
//     int e;   --> no of edges
//
//     ArrayList<Integer>[] edges; --> Adjacency list
//
// }

class Solution {
    
    public void DFS(int cv, boolean[] vis, Graph g){
        vis[cv] = true;
        
        for(int i=0; i<g.edges[cv].size(); i++)
        {
            int nbr = g.edges[cv].get(i);
            if(!vis[nbr]){
                DFS(nbr, vis, g);
            }
        }
    }
    
    public boolean isConnected(Graph g, int u, int v){
        boolean[] vis = new boolean[g.v];
        DFS(u, vis, g);
        
        if(!vis[u])
            return false;
        else {
            g.edges[u].remove((Object)v);
            g.edges[v].remove((Object)u);
            
            Arrays.fill(vis, false);
            DFS(u, vis, g);
            
            if(vis[v])
                return true;
            else 
                return false;
        }
    }
    
    public void isBridge(Graph g, int u, int v){
        if(isConnected(g, u, v))
            System.out.println(0);
        else
            System.out.println(1);
    }
}