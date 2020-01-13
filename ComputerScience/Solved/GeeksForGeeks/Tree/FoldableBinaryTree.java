//https://www.geeksforgeeks.org/foldable-binary-trees/

/*This is a function problem.You only need to complete the function given below*/
/*
node class of the binary tree
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
class GFG
{
    static Foldable_Tree obj = new Foldable_Tree();
    
    public static boolean isFoldable(Node root)
    {
        if(root==null){
            return true;
        }
        return isFoldableUtil(root.left,root.right);
    }
    
    public static boolean isFoldableUtil(Node a, Node b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        return isFoldableUtil(a.left,b.right) && isFoldableUtil(a.right,b.left);
    }
    
    
}