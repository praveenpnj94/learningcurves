//https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/


/*This is a function problem.You only need to complete the function given below*/
/* 
class Node
{
    int key;
    Node left, right;
    Node(int item)
    {
        key = item;
        left = right = null;
    }
}
*/
class BST
{   
    Node deleteNode(Node root, int key) 
    {
	    if(root==null){
	        return null;
	    }
	    if(root.key>key){
	        root.left = deleteNode(root.left,key);
	    }
	    else if(root.key<key){
	        root.right = deleteNode(root.right,key);
	    }
	    else{
	    if(root.left == null){
	        return root.right;
	    }
	    if(root.right == null){
	        return root.left;
	    }
	    if(root.left!=null && root.right != null){
	        Node del = getSuccessor(root.right,key);
	        root.key = del.key;
            root.right = deleteNode(root.right,del.key);
	    }	        
	    }
	    return root;
    }
    
    Node getSuccessor(Node root, int key){
        Node curr = root;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr;
    }
}
