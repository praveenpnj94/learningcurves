//https://www.tutorialspoint.com/Tarjan-s-Algorithm-for-Strongly-Connected-Components
//https://iq.opengenus.org/tarjans-algorithm/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG
{static StringBuilder sb = new StringBuilder();
static int time=0;
    static class Graph
    {
        int n;
        List<List<Integer>> adj = null;
        
        Graph(int n)
        {
            this.n = n;
            adj = new ArrayList<>();
            for(int i=0;i<n;i+=1)
            {
                adj.add(i,new ArrayList<>());
            }
        }
        
        void addEdge(int s,int d)
        {
            adj.get(s).add(d);
        }
    }
    
    static void SCC(Graph g,int u,int[] disc,int[] low,boolean[] stMember,Stack<Integer> st)
    {
        disc[u]=low[u]=++time;
        
        st.push(u);
        
        stMember[u]=true;
        
        for(Integer v: g.adj.get(u))
        {
            if(disc[v]==-1)
            {
                SCC(g,v,disc,low,stMember,st);
                low[u]=Math.min(low[u],low[v]);
            }
            else if(stMember[v]==true)
            {
                low[u]=Math.min(low[u],disc[v]);
            }
        }
        
       int w = 0;
	    List<Integer> ll = new ArrayList<Integer>();
	    if(low[u] == disc[u]){
	        while(st.peek() != u){
	           w = st.pop();
	           ll.add(w);
	           stMember[w] = false;
	        }
	        w = st.pop();
	        ll.add(w);
	        stMember[w] = false;
	        for(int i = 0; i < ll.size(); i++){
	            if(sb.length() > 0 && i != 0) sb.append(" ");
	            sb.append(ll.get(i));
	        }
	        sb.append(",");
	    }
    }
    
    static void SCCUtil(Graph g)
    {
        int[] disc = new int[g.n];
        int[] low = new int[g.n];
        boolean[] stMember = new boolean[g.n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<g.n;i+=1)
        {
            disc[i]=-1;
            low[i]=-1;
            stMember[i]=false;
        }
        for(int i=0;i<g.n;i+=1)
        {
            if(disc[i]==-1)
            {
                SCC(g,i,disc,low,stMember,st);
            }
        }
    }
     public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test-->0)
        {
            int n= s.nextInt();
            int m = s.nextInt();
             sb = new StringBuilder();
            Graph g = new Graph(n);
            for(int i=0;i<m;i+=1)
            {
                int src = s.nextInt();
                int dest = s.nextInt();
                if(src == dest) continue;
                g.addEdge(src,dest);
            }
            
            SCCUtil(g);
             System.out.println(sb);
        }
    }
}