//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

/*This is a function problem.You only need to complete the function given below*/
/*
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class GfG
{
    Node first, middle, last, prev; 
    public Node correctBST(Node root)
    {
// Initialize pointers needed  
        // for correctBSTUtil() 
        first = middle = last = prev = null; 
  
        // Set the poiters to find out  
        // two nodes 
        correctBSTUtil( root ); 
  
        // Fix (or correct) the tree 
        if( first != null && last != null ) 
        { 
            int temp = first.data; 
            first.data = last.data; 
            last.data = temp;  
        } 
        // Adjacent nodes swapped 
        else if( first != null && middle != 
                                    null )  
        { 
            int temp = first.data; 
            first.data = middle.data; 
            middle.data = temp; 
        } 
  
        // else nodes have not been swapped, 
        // passed tree is really BST. 
        return root;
    }
    
      
    // This function does inorder traversal 
    // to find out the two swapped nodes. 
    // It sets three pointers, first, middle 
    // and last. If the swapped nodes are 
    // adjacent to each other, then first  
    // and middle contain the resultant nodes 
    // Else, first and last contain the  
    // resultant nodes 
    void correctBSTUtil( Node root) 
    { 
        if( root != null ) 
        { 
            // Recur for the left subtree 
            correctBSTUtil( root.left); 
  
            // If this node is smaller than 
            // the previous node, it's  
            // violating the BST rule. 
            if (prev != null && root.data < 
                                prev.data) 
            { 
                // If this is first violation, 
                // mark these two nodes as 
                // 'first' and 'middle' 
                if (first == null) 
                { 
                    first = prev; 
                    middle = root; 
                } 
  
                // If this is second violation, 
                // mark this node as last 
                else
                    last = root; 
            } 
  
            // Mark this node as previous 
            prev = root; 
  
            // Recur for the right subtree 
            correctBSTUtil( root.right); 
        } 
    } 
    
}
