//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/?track=PC-W7-GR&batchId=127

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++) list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            boolean vis[] = new boolean[nov];
            for (int i = 0; i < nov; i++) vis[i] = false;
            new Traversal().bfs(0, list, vis, nov);
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*ArrayList<ArrayList<Integer>> list: represent graph containing vertices
                                    and edges between them
*vis[]: boolean array to represent visited vertex
*s: starting vertex
*/
class Traversal {
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean visited[],
                    int nov) {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int p = q.peek();
            q.remove();
            System.out.print(p+" ");
            for(int i=0;i<list.get(p).size();i++){
                int x = list.get(p).get(i);
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }
}