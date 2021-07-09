
class Solution {
    
    private TreeNode previous;
    private TreeNode inorderSuccessorNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            
            TreeNode leftmost = p.right;
            
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            
            this.inorderSuccessorNode = leftmost;
        } else {
            
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            this.inorderCase2(root, p);
        }
        
        return this.inorderSuccessorNode;
    }
    
    private void inorderCase2(TreeNode node, TreeNode p) {
        
        if (node == null) {
            return;
        }
        
        // Recurse on the left side
        this.inorderCase2(node.left, p);
        
        // Check if previous is the inorder predecessor of node
        if (this.previous == p && this.inorderSuccessorNode == null) {
            this.inorderSuccessorNode = node;
            return;
        }
        
        // Keeping previous up-to-date for further recursions
        this.previous = node;
        
        // Recurse on the right side
        this.inorderCase2(node.right, p);
    }
}


// Java program to find inorder successor of a node.


class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null; right = null;
	}
}

// class to find inorder successor of
// a node
class InorderSuccessor {
	Node root;
	
	// to change previous node
	static class PreviousNode {
		Node pNode;
		PreviousNode() {
			pNode = null;
		}
	}
	
	// function to find inorder successor of
	// a node
	private void inOrderSuccessorOfBinaryTree(Node root,
					PreviousNode pre, int searchNode)
	{
		// Case1: If right child is not NULL
		if(root.right != null)
		inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);
		
		// Case2: If root data is equal to search node
		if(root.data == searchNode)
		System.out.println("inorder successor of " + searchNode + " is: "
							+ (pre.pNode != null ? pre.pNode.data : "null"));
			pre.pNode = root;
			
		if(root.left != null)
		inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
	}
	
	// Driver program to test above functions
	public static void main(String[] args)
	{
		InorderSuccessor tree = new InorderSuccessor();
		
		// Let's construct the binary tree
		// as shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);
		
		// Case 1
		tree.inOrderSuccessorOfBinaryTree(tree.root,
										new PreviousNode(), 3);
		
		// Case 2
		tree.inOrderSuccessorOfBinaryTree(tree.root,
										new PreviousNode(), 4);
		
		// Case 3
		tree.inOrderSuccessorOfBinaryTree(tree.root,
										new PreviousNode(), 6);
	}
}
// This code is contributed by Ashish Goyal.
