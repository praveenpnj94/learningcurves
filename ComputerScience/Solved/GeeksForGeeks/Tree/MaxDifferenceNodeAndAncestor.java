//https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
//Back-end complete function Template for Java
/*
class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class GfG
{
    static int maxdiff;
    
    public static int maxDiff(Node root) {
        // Initialising result with minimum int value 
        Res res = new Res(); 
        maxDiffUtil(root, res); 
   
        return res.r; 
    }

    public static int maxDiffUtil(Node t, Res res)  
    { 
        /* Returning Maximum int value if node is not 
           there (one child case)  */
        if (t == null) 
            return Integer.MAX_VALUE; 
           
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null) 
            return t.data; 
   
        /* Recursively calling left and right subtree 
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res), 
                maxDiffUtil(t.right, res)); 
   
        /* Updating res if (node value - minimum value 
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.data - val); 
   
        /* Returning minimum value got so far */
        return Math.min(val, t.data); 
    } 
}
class Res  
{ 
    int r = Integer.MIN_VALUE; 
}
