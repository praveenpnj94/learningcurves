//https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/

/*This is a function problem.You only need to complete the function given below*/
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
//User function Template for Java
/*
Node defined as
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
    static Node prev;
    Node bTreeToClist(Node root)
    {
        prev = null; 
  
        // Set the previous pointer 
        fixPrevptr(root); 
  
        // Set the next pointer and return head of DLL 
        return fixNextptr(root); 
    }
    
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
        Node temp = root;
        while (root.right != null) 
            root = root.right; 
  
        Node temp2 = root;
        //root.right = temp;
        // Start from the rightmost node, traverse  
        // back using left pointers. While traversing,  
        // change right pointer of nodes 
        while (root != null && root.left != null)  
        { 
            Node left = root.left; 
            left.right = root; 
            root = root.left; 
        } 
        temp2.right = root;
        root.left = temp2;
  
        // The leftmost node is head of linked list, return it 
        return root; 
    }
    
}
    
