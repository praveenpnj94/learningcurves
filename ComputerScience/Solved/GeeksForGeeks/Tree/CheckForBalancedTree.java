//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/


/*This is a function problem.You only need to complete the function given below*/
/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
        if(root==null){
            return true;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.abs(lheight-rheight)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    int height(Node root){
        if(root == null){
            return 0;
        }
        return (int)Math.max(height(root.left),height(root.right))+1;
    }
}
