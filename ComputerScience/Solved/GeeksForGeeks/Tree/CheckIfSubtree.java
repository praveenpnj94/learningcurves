//https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
//https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/

/*This is a function problem.You only need to complete the function given below*/

/*complete the given function*/
/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/
class Tree {
    
    static boolean areIdentical(Node root1, Node root2)  
    { 
   
        /* base cases */
        if (root1 == null && root2 == null) 
            return true; 
   
        if (root1 == null || root2 == null) 
            return false; 
   
        /* Check if the data of both roots is same and data of left and right 
           subtrees are also same */
        return (root1.data == root2.data 
                && areIdentical(root1.left, root2.left) 
                && areIdentical(root1.right, root2.right)); 
    } 
   
    /* This function returns true if S is a subtree of T, otherwise false */
    static boolean isSubtree(Node T, Node S)  
    { 
        /* base cases */
        if (S == null)  
            return true; 
   
        if (T == null) 
            return false; 
   
        /* Check the tree with root as current node */
        if (areIdentical(T, S))  
            return true; 
   
        /* If the tree with root as current node doesn't match then 
           try left and right subtrees one by one */
        return isSubtree(T.left, S) 
                || isSubtree(T.right, S); 
    } 
}
