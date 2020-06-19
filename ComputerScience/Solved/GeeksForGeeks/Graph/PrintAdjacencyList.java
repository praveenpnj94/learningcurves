//https://practice.geeksforgeeks.org/problems/print-adjacency-list/0/?track=PC-W7-GR&batchId=127
//https://www.geeksforgeeks.org/graph-and-its-representations/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String[] dim = br.readLine().trim().split(" ");
            int V = Integer.parseInt(dim[0]);
            int E = Integer.parseInt(dim[1]);
            Graph g = new Graph(V,E);
            ArrayList<ArrayList<Integer>> adjList = g.adjList;
            for(int i =0;i<E;i++){
                String[] path = br.readLine().trim().split(" ");
                int src = Integer.parseInt(path[0]);
                int dest = Integer.parseInt(path[1]);
                g.addEdge(adjList,src,dest);
            }
            g.printGraph(adjList);
        }
	}
}
class Graph{
    int V;
    int E;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    Graph(int v, int e){
        V=v;
        E=e;
        for(int i =0;i<v;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }
    
    void addEdge(ArrayList<ArrayList<Integer> > adj, 
                        int u, int v) 
    { 
        adj.get(u).add(v); 
        adj.get(v).add(u); 
    } 
    
    void printGraph(ArrayList<ArrayList<Integer>> adjList){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i);
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print("-> "+adjList.get(i).get(j));
            }
            System.out.println();
        }
    }
}