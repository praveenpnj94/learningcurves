//https://www.techiedelight.com/find-inorder-successor-given-key-bst/

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class GfG
{

	// Recursive function to find inorder successor for given key in a BST
	public static Node findSuccessor(Node root, Node succ, int key)
	{
		// base case
		if (root == null) {
			return null;
		}

		// if node with key's value is found, the successor is minimum
		// value node in its right subtree (if any)
		if (root.data == key)
		{
			if (root.right != null) {
				return findMinimum(root.right);
			}
		}

		// if given key is less than the root node, recur for left subtree
		else if (key < root.data)
		{
			// update successor to current node before recursing in 
			// left subtree
			succ = root;
			return findSuccessor(root.left, succ, key);
		}

		// if given key is more than the root node, recur for right subtree
		else {
			return findSuccessor(root.right, succ, key);
		}

		return succ;
	}
	
	public Node inorderSuccessor(Node root,Node n){
	    		Node succ = null;
	    int key = n.data;

		while (true)
		{
			// if given key is less than the root node, visit left subtree
			if (key < root.data)
			{
				// update successor to current node before visiting
				// left subtree
				succ = root;
				root = root.left;
			}

			// if given key is more than the root node, visit right subtree
			else if (key > root.data)
			{
				root = root.right;
			}

			// if node with key's value is found, the successor is minimum
			// value node in its right subtree (if any)
			else
			{
				if (root.right != null) {
					succ = minValue(root.right);
				}
				break;
			}
			
			// if key doesn't exist in binary tree
			if (root == null)
				return null;
		}

		// return Successor if any
		return succ;
	}
    
    public Node minValue(Node node){
        Node current = node; 
  
        /* loop down to find the leftmost leaf */
        while (current.left != null) { 
            current = current.left; 
        } 
        return current; 
    }
}