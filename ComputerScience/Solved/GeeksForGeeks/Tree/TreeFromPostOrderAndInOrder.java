//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/
//https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/

/*This is a function problem.You only need to complete the function given below*/
/* Tree node structure
class Node
{
	int data;
	Node left;
	Node right;
        
        Node(int value)
	{
		data = value;
		left = null;
		right = null;
	}
}*/
// Function should construct tree and return
// root of it.  in[] stores inorder traversal
// post[] stores postorder traversal.  n is
// size of these arrays
class GfG
{
    int pIndex;
	// Complete the function
    Node buildTree(int in[], int post[], int n)
	{
	    
           HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
           int idx = 0;
           for(int i :in){
               m.put(i,idx);
               idx++;
           }
           pIndex = n-1;
           return buildTreeUtil(in,post,n,m,0,n-1);
	}
	
	Node buildTreeUtil(int in[], int post[], int n, HashMap<Integer,Integer> m,int start, int end){
	    if(start>end){
	        return null;
	    }
	    
	    Node root = new Node(post[pIndex]);
	    int index = m.get(root.data);
	    pIndex--;
	    root.right = buildTreeUtil(in,post,n,m,index+1,end);
	    root.left = buildTreeUtil(in,post,n,m,start,index-1);
	    return root;
	}
}
