//https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/

class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        
        while (root != null) {
            
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        
        return successor;
    }
}

// Java program for above approach
class GFG
{

/* A binary tree node has data,
the pointer to left child
and a pointer to right child */
static class node
{
	int data;
	node left;
	node right;
	node parent;
};

static node inOrderSuccessor(
	node root,
	node n)
{
	
	// step 1 of the above algorithm
	if (n.right != null)
		return minValue(n.right);

	node succ = null;

	// Start from root and search for
	// successor down the tree
	while (root != null)
	{
		if (n.data < root.data)
		{
			succ = root;
			root = root.left;
		}
		else if (n.data > root.data)
			root = root.right;
		else
			break;
	}
	return succ;
}

/* Given a non-empty binary search tree,
	return the minimum data
	value found in that tree. Note that
	the entire tree does not need
	to be searched. */
static node minValue(node node)
{
	node current = node;

	/* loop down to find the leftmost leaf */
	while (current.left != null)
	{
		current = current.left;
	}
	return current;
}

/* Helper function that allocates a new
	node with the given data and
	null left and right pointers. */
static node newNode(int data)
{
	node node = new node();
	node.data = data;
	node.left = null;
	node.right = null;
	node.parent = null;

	return (node);
}

/* Give a binary search tree and
a number, inserts a new node with
	the given number in the correct
	place in the tree. Returns the new
	root pointer which the caller should
	then use (the standard trick to
	astatic void using reference parameters). */
static node insert(node node,
					int data)
{

	/* 1. If the tree is empty, return a new,
	single node */
	if (node == null)
		return (newNode(data));
	else
	{
		node temp;

		/* 2. Otherwise, recur down the tree */
		if (data <= node.data)
		{
			temp = insert(node.left, data);
			node.left = temp;
			temp.parent = node;
		}
		else
		{
			temp = insert(node.right, data);
			node.right = temp;
			temp.parent = node;
		}

		/* return the (unchanged) node pointer */
		return node;
	}
}

/* Driver program to test above functions*/
public static void main(String[] args)
{
	node root = null, temp, succ, min;

	// creating the tree given in the above diagram
	root = insert(root, 20);
	root = insert(root, 8);
	root = insert(root, 22);
	root = insert(root, 4);
	root = insert(root, 12);
	root = insert(root, 10);
	root = insert(root, 14);
	temp = root.left.right.right;
	
	// Function Call
	succ = inOrderSuccessor(root, temp);
	if (succ != null)
		System.out.printf(
			"\n Inorder Successor of %d is %d ",
			temp.data, succ.data);
	else
		System.out.printf("\n Inorder Successor doesn't exit");
}
}

// This code is contributed by gauravrajput1
