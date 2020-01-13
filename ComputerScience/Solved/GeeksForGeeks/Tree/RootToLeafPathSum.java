//https://www.youtube.com/watch?v=Jg4E4KZstFE


/*This is a function problem.You only need to complete the function given below*/
/*
// A Binary Tree node
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
    /*you are required to complete this function */
    boolean hasPathSum(Node node, int sum)
    {
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            if(node.data==sum){
                return true;
            }
            return false;
        }
        if(hasPathSum(node.left,sum-node.data)){
            return true;
        }
        if(hasPathSum(node.right,sum-node.data)){
            return true;
        }
        return false;
    }
}