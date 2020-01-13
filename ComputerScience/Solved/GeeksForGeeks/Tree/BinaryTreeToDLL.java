//https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
//https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
//https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/


/*This is a function problem.You only need to complete the function given below*/
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/
// This function should convert a given Binary tree to Doubly
// Linked List
class GfG
{
    Node head;
    static Node prev; 
    Node bToDLL(Node root)
    {
        prev = null; 
  
        // Set the previous pointer 
        fixPrevptr(root); 
  
        // Set the next pointer and return head of DLL 
        return fixNextptr(root); 
    }
    
        // Changes left pointers to work as previous  
    // pointers in converted DLL The function  
    // simply does inorder traversal of Binary  
    // Tree and updates left pointer using  
    // previously visited node 
    void fixPrevptr(Node root)  
    { 
        if (root == null) 
            return; 
  
        fixPrevptr(root.left); 
        root.left = prev; 
        prev = root; 
        fixPrevptr(root.right); 
  
    } 
  
    // Changes right pointers to work  
    // as next pointers in converted DLL 
    Node fixNextptr(Node root)  
    {         
        // Find the right most node in  
        // BT or last node in DLL 
        while (root.right != null) 
            root = root.right; 
  
        // Start from the rightmost node, traverse  
        // back using left pointers. While traversing,  
        // change right pointer of nodes 
        while (root != null && root.left != null)  
        { 
            Node left = root.left; 
            left.right = root; 
            root = root.left; 
        } 
  
        // The leftmost node is head of linked list, return it 
        return root; 
    }


        // A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoubleLinkedList(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    } 
}
