//https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String[] arr = br.readLine().trim().split(" ");
		    int[] a = new int[n];
		    int i=0;
		    for(String s:arr){
		        a[i] = Integer.parseInt(s);
		        i++;
		    }
		    Node root = arrayToBst(a,0,n-1);
		    preorder(root);
		    System.out.println();
		}
	}
	public static Node arrayToBst(int[] a, int start, int end){
	    if(start>end){
	        return null;
	    }
	    int mid = start+(end-start)/2 ;
	    Node root = new Node(a[mid]);
	    if(start==end){
	        return root;
	    }
	    root.left = arrayToBst(a,start,mid-1);
	    root.right = arrayToBst(a,mid+1,end);
	    return root;
	}
	public static void preorder(Node root){
	    if(root==null){
	        return;
	    }
	    System.out.print(root.data+" ");
	    preorder(root.left);
	    preorder(root.right);
	}
}