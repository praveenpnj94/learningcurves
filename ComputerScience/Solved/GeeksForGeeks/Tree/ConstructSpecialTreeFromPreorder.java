//https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/

/*package whatever //do not write package name here */

import java.io.*;
class Node 
{
    int data;
    Node left;
    Node right;
    Node(int d)
    {
        data=d;
    }
}
class BinaryTree
{
    static int preindex;
    Node SpecialTree(int[]pre,char[]preLn)
    {
        
        Node tnode=new Node(pre[preindex]);  
        if(preLn[preindex]=='L')
        {
           preindex++;
           return tnode;
        }
        else
            preindex++;
        tnode.left=SpecialTree(pre,preLn);
        tnode.right=SpecialTree(pre,preLn);
        return tnode;
    }
    void preorder(Node root)
    {
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
        
    }
}    
class GFG {
	public static void main (String[] args) {
		
        int[] pre={10,30,20,5,15,25,30};
        char[] preLn={'N','N','L','L','N','L','L'};
        
        BinaryTree b=new BinaryTree();
 
        Node  root=b.SpecialTree(pre,preLn);
        b.preorder(root);
	}
}