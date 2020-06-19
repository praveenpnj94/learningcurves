/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    HashMap<Integer,Integer> m = new HashMap<>();
		    for(int i=0; i<n ;i++){
		       m.put(sc.nextInt(),sc.nextInt());
		    }
		    System.out.println(minDiceSnake(30,m));
		}
	}
	public static int minDiceSnake(int dim, HashMap<Integer,Integer> m){
	    Queue<Node> q = new LinkedList<>();
	    boolean[] vis = new boolean[dim+1];
	    q.add(new Node(1,0));
	    vis[0] = true;
	    vis[1] = true;
	    while(!q.isEmpty()){
	        Node p = q.poll();
	        int pos = p.pos;
	        int dist = p.dist;
	        if(pos==dim){
	            return dist;
	        }
	        for(int i=1;i<=6;i++){
	            int newPos = pos+i;
	            if(m.containsKey(newPos)){
	                newPos = m.get(newPos);
	            }
	            if(newPos<=dim && !vis[newPos]){
	                vis[newPos] = true;
	                q.add(new Node(newPos,dist+1));
	            }
	        }
	    }
	    return -1;
	}
}
class Node{
    int pos;
    int dist;
    Node(int p, int d){
        pos = p;
        dist = d;
    }
}