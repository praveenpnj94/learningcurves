//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
//https://www.youtube.com/watch?v=F-_1sbnPbWQ
//https://www.youtube.com/watch?v=13m9ZCB8gjw


/*This is a function problem.You only need to complete the function given below*/
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
/* If n1 and n2 are present, return reference
   to LCA. If both are not present, return 
   null,. Else if left subtree contains any 
   of them return pointer to left.*/
	Node lca(Node root, int n1,int n2)
	{
		if(root==null){
		    return null;
		}
		if(root.data == n1 || root.data == n2){
		    return root;
		}
		Node l = lca(root.left,n1,n2);
		Node r = lca(root.right,n1,n2);
		if(l!=null && r!=null){
		    return root;
		}
		return l!=null?l:r;
	}
}
