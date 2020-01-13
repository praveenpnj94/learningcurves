//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/


/*This is a function problem.You only need to complete the function given below*/
/*  A Binary Search Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class GfG
{
    int isBST(Node root)  
    {
        if(root==null){
            return 1;
        }
        boolean ans = isBstUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return ans?1:0;
    }
    
    boolean isBstUtil(Node root,int min,int max){
        if(root == null){
            return true;
        }
        return root.data<max && root.data > min && isBstUtil(root.left,min,root.data) && isBstUtil(root.right,root.data,max);
    }
}
