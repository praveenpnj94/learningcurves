//https://www.geeksforgeeks.org/zigzag-tree-traversal/

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
// Print the zig zag traversal of tree.
class GFG
{
	void zigZagTraversal(Node root)
	{
	    Stack<Node> s1 = new Stack<Node>();
	    Stack<Node> s2 = new Stack<Node>();
	    s2.add(root);
	    while(!s1.isEmpty()||!s2.isEmpty()){
	        while(!s1.isEmpty()){
	            Node temp = s1.pop();
	            System.out.print(temp.data+" ");
	            if(temp.right!=null){
	                s2.push(temp.right);
	            }
	            if(temp.left!=null){
	                s2.push(temp.left);
	            }
	        }
	        while(!s2.isEmpty()){
	            Node temp = s2.pop();
	            System.out.print(temp.data+" ");
	            if(temp.left!=null){
	                s1.push(temp.left);
	            }
	            if(temp.right!=null){
	                s1.push(temp.right);
	            }
	        }
	    }
	}
}